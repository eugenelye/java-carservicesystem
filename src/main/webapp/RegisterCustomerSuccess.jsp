<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
out.println("Dear "+session.getAttribute("name")+", you have successfullly registered.");
%>
<br>
<a href = "CustomerLogin.html">Customer Login</a><br>
</body>
</html>