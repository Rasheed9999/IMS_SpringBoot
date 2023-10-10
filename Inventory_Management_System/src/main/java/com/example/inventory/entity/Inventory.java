package com.example.inventory.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class Inventory {
	
	@Id
	private long itemID;
	private String itemName;
	private long ReorderThreshold;
	private long QuantityAvailable;
	
	
	


	public Inventory(long itemID, String itemName, long reorderThreshold, long quantityAvailable) {
		super();
		this.itemID = itemID;
		this.itemName = itemName;
		ReorderThreshold = reorderThreshold;
		QuantityAvailable = quantityAvailable;
	}



	public long getItemID() {
		return itemID;
	}



	public void setItemID(int itemID) {
		this.itemID = itemID;
	}



	public String getItemName() {
		return itemName;
	}



	public void setItemName(String itemName) {
		this.itemName = itemName;
	}



	public long getReorderThreshold() {
		return ReorderThreshold;
	}



	public void setReorderThreshold(long reorderThreshold) {
		ReorderThreshold = reorderThreshold;
	}



	public long getQuantityAvailable() {
		return QuantityAvailable;
	}



	public void setQuantityAvailable(long quantityAvailable) {
		QuantityAvailable = quantityAvailable;
	}






	public Inventory() {
		super();
	}
	
	
	
}
