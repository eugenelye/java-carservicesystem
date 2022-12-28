<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ page import = "java.util.*" %>
<%@ page import = "com.accenture.model.*" %>
<%
	ArrayList<CustomerDetails> al = (ArrayList<CustomerDetails>)session.getAttribute("al");
%>
<table border=1px solid black>
  <tr>
    <td>Name</td>
    <td>Username</td>
    <td>Email</td>
    <td></td>
    <td></td>
  </tr>
  <%
  for(CustomerDetails user : al) {
  %>
  <tr>
    <td><%= user.getName() %></td>
    <td><%= user.getUsername() %></td>
    <td><%= user.getEmail()  %></td>
	<td><a href="UpdateCustomerDetail.jsp"><button>Update</button></a></td>
    <td><button action="/car-service-mvc/DeleteCustomer">Delete</button></td>
  </tr>
  <%
  }
  %>
</table>
</body>
</html>