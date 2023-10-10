package com.example.inventory.services;

import java.util.List;

import com.example.inventory.entity.Inventory;
import com.example.inventory.entity.Login;
import com.example.inventory.model.Registration;

public interface Services {
	
	public String authentication(Login login);
	public String registration(Registration registration);
	public String editInventory(Long itemId, Long qty);
	public List<Inventory> getLowStockItems();
	public List<Inventory> getInventorys();
	
}
