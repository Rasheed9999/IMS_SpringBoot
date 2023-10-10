package com.example.inventory.servicesimpl;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.inventory.entity.Inventory;
import com.example.inventory.entity.Login;
import com.example.inventory.entity.Users;
import com.example.inventory.model.Registration;
import com.example.inventory.repos.InventoryRepo;
import com.example.inventory.repos.LoginRepo;
import com.example.inventory.repos.UserRepo;
import com.example.inventory.services.Services;

@Service
public class ServicesImplementation implements Services {

	@Autowired
	LoginRepo loginrepo;

	@Autowired
	UserRepo userrepo;


	@Autowired
	InventoryRepo inventoryrepo;
	

	@Override
	public String authentication(Login login) {
		// TODO Auto-generated method stub
		
		
		Login logindetails = loginrepo.findById(login.getEmail()).get();
		
		
		if (logindetails.getPassword().equals(login.getPassword())) {
			return userrepo.findById(logindetails.getEmail()).get().getRole();
		}
		
		return "Invalid UserId or Password";
	}
		
		
	

	@Override
	public String registration(Registration registration) {
		// TODO Auto-generated method stub
		if(userrepo.existsByEmail(registration.getEmail())) {
			return "User Exists";
		}else {
		Users user = new Users(registration.getLastname(), registration.getFirstname(), registration.getEmail(),
				registration.getRole());
		userrepo.save(user);
		Login login = new Login(registration.getEmail(), registration.getPassword());
		loginrepo.save(login);
		return registration.getEmail();
		}
		
	}

	@Override
	public String editInventory(Long itemId, Long qty) {
		// TODO Auto-generated method stub

	
		Inventory inventory = (Inventory) inventoryrepo.findById(itemId).get();

		inventory.setQuantityAvailable(inventory.getQuantityAvailable()+qty);

		inventoryrepo.save(inventory);

		return "updated";
	}

	
	
	
	@Override
	public List<Inventory> getInventorys() {

		return 	StreamSupport.stream(inventoryrepo.findAll().spliterator(), false)
			    .collect(Collectors.toList());
		

	}

	@Override
	public List<Inventory> getLowStockItems() {
		// TODO Auto-generated method stub
		
		return 	StreamSupport.stream(inventoryrepo.findAll().spliterator(), false).filter(i -> i.getQuantityAvailable() < i.getReorderThreshold())
			    .collect(Collectors.toList());
	}

	
	
	
	
}
