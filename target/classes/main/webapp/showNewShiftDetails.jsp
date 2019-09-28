<%@page import="rrn.pojos.Shift"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reserved shift details</title>
<style>
body  {background-color: greenyellow;}
</style>
</head>
<body>
Tura s-a salvat cu succes si are urmatoarele date: <p>
	<%
		Shift shiftToDisplay = (Shift) request.getAttribute("newShift");
		out.println(shiftToDisplay.getNurseID());
		out.println(shiftToDisplay.getStartDate());
		out.println(shiftToDisplay.getEndDate());
	%>
	
	<form action="Logout">
	<input type="submit" value="Logout">
	</form>
</body>
</html>