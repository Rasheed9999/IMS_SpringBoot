package com.example.inventory.entity;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class Users {
	 
	@Id
	private String email;
	private String lastname;
	private String firstname;
	
	private String role;
	
	
	
	public Users(String lastname, String firstname, String email, String role) {
		super();
		this.lastname = lastname;
		this.firstname = firstname;
		this.email = email;
		this.role = role;
	}



	public String getLastname() {
		return lastname;
	}



	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	public String getFirstname() {
		return firstname;
	}



	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	public Users() {
		super();
	}
	
	
	
}
