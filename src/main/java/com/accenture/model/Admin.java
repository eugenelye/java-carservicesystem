package com.accenture.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Admin {

	private String admin_username;
	private String admin_password;

	public Admin(String admin_username, String admin_password) {
		super();
		this.admin_username = admin_username;
		this.admin_password = admin_password;
	}

	public Admin() {

	}

	public String getUsername() {
		return admin_username;
	}

	public void setUsername(String admin_username) {
		this.admin_username = admin_username;
	}

	public String getPassword() {
		return admin_password;
	}

	public void setPassword(String admin_password) {
		this.admin_password = admin_password;
	}


	
	public int adminLogin() {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			System.out.println("Connection Estbalished Succesfully");

//			2) Establish Connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample_acc_db?serverTimezone=UTC",
					"root", "Eugene546933.");
			System.out.println("Connection Established Successfully");
			
			String s = "select * from admin_db where admin_username=?";
			PreparedStatement pstmt=con.prepareStatement(s);
			
			pstmt.setString(1, admin_username);
			ResultSet res = pstmt.executeQuery();
			
			if (res.next()) {
				if (res.getString(2).equals(admin_password)) {
					return 1;
				} else {
					return 0;
				}
			} else {
				return -1;//invalid username
			}
	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
		
	}
	
	

}
