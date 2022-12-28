package com.accenture.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.accenture.model.Customer;

/**
 * Servlet implementation class EditCustomer
 */
public class EditCustomer extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name =request.getParameter("name");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		
		Customer tempCustomer = new Customer(name,username,email);
		int rows = tempCustomer.customerEdit();
		
//		HttpSession session = request.getSession(true);
//		session.setAttribute("name", name);
		
		
		if (rows==-1) {
			response.sendRedirect("/car-service-mvc/UpdateCustomerDetailUserNotFound.jsp");

		} else if(rows==1) {

			response.sendRedirect("/car-service-mvc/AdminLoginSuccess.jsp");
		}
		
		else {
			response.sendRedirect("/car-service-mvc/RegisterFailure.html");
		}
	}

}
