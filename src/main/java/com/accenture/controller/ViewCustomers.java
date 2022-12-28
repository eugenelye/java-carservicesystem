package com.accenture.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.accenture.model.Customer;
import com.accenture.model.CustomerDetails;


public class ViewCustomers extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customer c = new Customer();
		ArrayList<CustomerDetails> al=c.viewCustomers();
		
		HttpSession session = request.getSession(true);
		session.setAttribute("al", al);
		response.sendRedirect("/car-service-mvc/ViewCustomersSuccess.jsp");
	}

}
