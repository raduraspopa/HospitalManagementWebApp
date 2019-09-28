<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
<style>
body     {background-color: greenyellow;}
input    {display: table-column;}
</style>
</head>
<body>
	Welcome to shifts scheduler!
	<p>
	<p>Please enter your credentials to reserve a new shift:
	<p>
	<form action="Login">
	Enter username: <input type="text" name="uname"><br>
	Enter password: <input type="password" name="pass"><br>
	<input type="submit" value="Login">
	</form>
</body>
</html>