package com.accenture.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Customer {
	private String name;
	private String username;
	private String password;
	private String email;

	public Customer(String name, String username, String password, String email) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public Customer(String username, String password) {
		super();

		this.username = username;
		this.password = password;

	}

	public Customer(String name, String username, String email) {
		super();
		
		this.name = name;
		this.username = username;
		this.email = email;

	}

	public Customer() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int customerRegister() {
		try {
			// 1)Load driver
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			System.out.println("Connection Estbalished Succesfully");

//			2) Establish Connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample_acc_db?serverTimezone=UTC",
					"root", "Eugene546933.");
			System.out.println("Connection Established Successfully");

			while (true) {

				String s1 = "select * from customer_db where username=?";
				PreparedStatement pstmt1 = con.prepareStatement(s1);
				pstmt1.setString(1, username);
				ResultSet res = pstmt1.executeQuery();

				if (res.next()) {
					return -1;
				} else {
					String s = "insert into customer_db values(?,?,?,?)";

					PreparedStatement pstmt = con.prepareStatement(s);

					pstmt.setString(1, name);
					pstmt.setString(2, username);
					pstmt.setString(3, password);
					pstmt.setString(4, email);

					int rows = pstmt.executeUpdate();
					return rows;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int customerLogin() {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			System.out.println("Connection Estbalished Succesfully");

//			2) Establish Connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample_acc_db?serverTimezone=UTC",
					"root", "Eugene546933.");
			System.out.println("Connection Established Successfully");

			String s = "select * from customer_db where username=?";
			PreparedStatement pstmt = con.prepareStatement(s);

			pstmt.setString(1, username);
			ResultSet res = pstmt.executeQuery();

			if (res.next()) {
				if (res.getString(3).equals(password)) {
					return 1;
				} else {
					return 0;
				}
			} else {
				return -1;// invalid username
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;

	}

	public ArrayList<CustomerDetails> viewCustomers() {
		try {
			// 1)Load driver
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			System.out.println("Connection Estbalished Succesfully");

//			2) Establish Connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample_acc_db?serverTimezone=UTC",
					"root", "Eugene546933.");
			System.out.println("Connection Established Successfully");

			String s = "select * from customer_db";
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(s);

			ArrayList<CustomerDetails> al = new ArrayList<CustomerDetails>();

			while (res.next()) {
				name = res.getString(1);
				username = res.getString(2);
				email = res.getString(4);

				al.add(new CustomerDetails(name, username, email));
			}

			return al;

		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public int customerEdit() {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			System.out.println("Connection Estbalished Succesfully");

//			2) Establish Connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample_acc_db?serverTimezone=UTC",
					"root", "Eugene546933.");
			System.out.println("Connection Established Successfully");

			while (true) {

				String s1 = "select * from customer_db where username=?";
				PreparedStatement pstmt1 = con.prepareStatement(s1);
				pstmt1.setString(1, username);
				ResultSet res = pstmt1.executeQuery();

				if (!res.next()) {
					return -1;
				} else {
					String s = "update customer_db set name=?, email=? where username=?";
					PreparedStatement pstmt = con.prepareStatement(s);

					pstmt.setString(1, name);
					pstmt.setString(2, email);
					pstmt.setString(3, username);

					int rows = pstmt.executeUpdate();
					return rows;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;

	}
}
