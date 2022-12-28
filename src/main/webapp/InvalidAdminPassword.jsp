<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Invalid Admin Password!</h1>
	<form action="/car-service-mvc/LoginAdmin">
		<table>
			<tr>
				<td>Username:</td>
				<td><input type="text" name="admin_username"></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="admin_password"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Login"></td>
			</tr>
		</table>
	</form>

</body>
</html>