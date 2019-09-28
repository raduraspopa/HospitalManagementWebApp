<%@page import="rrn.pojos.Shift"%>
<%@page import="rrn.dao.Dao"%>
<%@page import= "java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shift not eligible</title>
<style>
body     {background-color: greenyellow;}
</style>
</head>
<body>
The shift you chose is not eligible.<br>
Please make sure you respect the following rules:<p>
1. The morning shift should start at 08:00 and end at 14:00 if it is a working day;<br>
2. The afternoon shift should start at 14:00 and end at 20:00 if it is a working day;<br>
3. The night shift should start at 20:00 and end at 08:00 regardless of the week day;<br>
4. During weekend days, the shift should start at 08:00 and end at 20:00;<br>
5. A maximum number of 6 nurses are allowed during the working days morning shift and 2 nurses/shift otherwise;<br>
<p>
<a href="http://localhost:8080/WebAppHospitalManagement/index.jsp">Click here to request a new shift</a>
<p>
<%
 List<Shift> previouslySavedShifts = Dao.getAlreadySavedShifts();
 for(Shift s:previouslySavedShifts){
 	out.println("Nurse with ID "+s.getNurseID()+
 			   " ,start date "+s.getStartDate()+
 			   " and end date "+
 			   s.getEndDate()+
 			   ";");
 	
	out.println("<br>");
 }
 %>
	
	<form action="Logout">
	<input type="submit" value="Logout">
	</form>
</body>
</html>