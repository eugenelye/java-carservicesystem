package com.accenture.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accenture.model.Admin;

/**
 * Servlet implementation class LoginAdmin
 */
public class LoginAdmin extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String admin_username = request.getParameter("admin_username");
		String admin_password = request.getParameter("admin_password");
		
		Admin a = new Admin(admin_username, admin_password);
		int x= a.adminLogin();
		
		if (x==-1) {
			response.sendRedirect("/car-service-mvc/InvalidAdminUsername.jsp");
		} else if (x==0) {
			response.sendRedirect("/car-service-mvc/InvalidAdminPassword.jsp");
		} else {
			response.sendRedirect("/car-service-mvc/AdminLoginSuccess.jsp");
		}
	}
	

}
