package com.example.inventory.model;

import java.util.Date;

//import javax.persistence.Entity;


public class Registration {
	
	private String lastname;
	private String firstname;
	private String email;
	private String role;
	private String password;
	
	
	
	public Registration(String lastname, String firstname, String email, String role, String password) {
		super();
		this.lastname = lastname;
		this.firstname = firstname;
		this.email = email;
		this.role = role;
		this.password = password;
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



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public Registration() {
		super();
	}
	
	

}