<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<body>
<%
if(session.getAttribute("username")==null){
	response.sendRedirect("http://localhost:8080/WebAppHospitalManagement/Welcome.jsp");
}
%>
	<h2>Welcome to shifts scheduling!</h2>
	<form action="GetShiftsController">

		<input type="text" name="nurseID"> 
		<input type="text" name="shiftStartDate">
		<input type="text" name="shiftEndDate">
		<input type="submit">

	</form>
	
	<p>
	
	<form action="Logout">
	<input type="submit" value="logout">
	</form>
</body>
</html>