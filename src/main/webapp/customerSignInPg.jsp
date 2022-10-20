<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Touch Customer Sign In Page</title>
</head>
<body>
<center>
	<small>YOU ARE JUST A MIN AWAY TO GET IN <big>TOUCH</big></small>
	<table>
		<form action="CustomerSignIn" method="post">
		<tr>
		<td>Username</td>
		<td><input type="email" name="email" placeholder="enter user email" required></td>
		</tr>
		<tr>
		<td>Password</td>
		<td><input type="password" name="password" placeholder="enter password here" required></td>
		</tr>
		<tr>
		<td>If you dont have account register <a href="customerSignUpPg.jsp">Here</a></td>
		<td><input type="submit" value="login"></td>
		</tr>
		</tr>
		
		</form>
	</table>
	</center>
</body>
</html>