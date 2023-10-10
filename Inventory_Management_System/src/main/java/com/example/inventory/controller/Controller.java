package com.example.inventory.controller;

import java.sql.Time;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.inventory.entity.Inventory;
import com.example.inventory.entity.Login;
import com.example.inventory.model.Registration;
import com.example.inventory.response.Message;
import com.example.inventory.services.Services;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class Controller {

	@Autowired
	Services services;

	@PostMapping("/login")
	public ResponseEntity<Message> login(@RequestBody Login login) {

		return new ResponseEntity<>(new Message(services.authentication(login)), HttpStatus.OK);
		

	}

	@PostMapping("/register")
	public ResponseEntity<Message> registrationPage(@RequestBody Registration registration) {

		if(services.registration(registration).equals(registration.getEmail()))
		return new ResponseEntity<>(new Message("user is created"),
					HttpStatus.OK);
		else return new ResponseEntity<>(new Message("user exists"), HttpStatus.BAD_REQUEST);
	

	}

	

	@GetMapping("/getInventorys")
	public ResponseEntity<List<Inventory>> getInventory() {

		
		List<Inventory> inventorys = services.getInventorys();
		if(!inventorys.isEmpty())
		return new ResponseEntity<>(inventorys,HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		

	}
	
	@GetMapping("/procurement/low-stock-items")
	public ResponseEntity<List<Inventory>> getLowStockItems() {

		
		List<Inventory> inventorys = services.getLowStockItems();
		if(!inventorys.isEmpty())
		return new ResponseEntity<>(inventorys,HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		

	}
	
	@PostMapping("/procurement/purchase-order/{itemId}/{qty}")
	public ResponseEntity<Message> updateInventory(@PathVariable Long itemId, @PathVariable Long qty) {

		HttpStatus status;
		status = HttpStatus.OK;


		return new ResponseEntity<>(new Message(services.editInventory(itemId, qty)), status);

		

	}

}
