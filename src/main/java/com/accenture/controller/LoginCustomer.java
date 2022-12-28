package com.accenture.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.accenture.model.Customer;

/**
 * Servlet implementation class LoginCustomer
 */
public class LoginCustomer extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Customer tempCustomer = new Customer(username, password);
		int x= tempCustomer.customerLogin();
		
		if (x==-1) {
			response.sendRedirect("/car-service-mvc/InvalidCustomerUsername.jsp");
		} else if (x==0) {
			response.sendRedirect("/car-service-mvc/InvalidCustomerPassword.jsp");
		} else {
			response.sendRedirect("/car-service-mvc/CustomerLoginSuccess.jsp");
		}
	
	}
}
