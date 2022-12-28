package com.accenture.model;

public class CustomerDetails {
	private String name;
	private String username;
	private String email;

	public CustomerDetails(String name, String username, String email) {
		super();
		this.name = name;
		this.username = username;
		this.email = email;
	}

	public String getName() {
		return name;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "CustomerDetails [name=" + name + ", username=" + username + ", email=" + email + "]";
	}

}
