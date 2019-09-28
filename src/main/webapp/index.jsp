<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shift not eligible</title>
<style>
body     {background-color: greenyellow;}
input    {display: table-column;}
</style>
</head>
<body>
<%
if(session.getAttribute("username")==null){
	response.sendRedirect("http://localhost:8080/WebAppHospitalManagement/Welcome.jsp");
}
%>
	<h2>Welcome to shifts scheduling!</h2>
	<form action="GetShiftsController">

		Nurse Id: <input type="text" name="nurseID"> 
		Shift start date: <input type="text" name="shiftStartDate">
		Shift end date: <input type="text" name="shiftEndDate">
		<p>
		<input type="submit" value="Submit">

	</form>
	
	<p>
	
	<form action="Logout">
	<input type="submit" value="Logout">
	</form>
</body>
</html>