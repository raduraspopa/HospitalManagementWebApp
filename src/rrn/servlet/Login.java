package rrn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import rrn.dao.Dao;
import rrn.pojos.HeadStaff;

public class Login extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		
		List<HeadStaff> HeadStaffList = Dao.getHeadStaffList();
		boolean userIsValid=false;
		
		for(HeadStaff hs:HeadStaffList) {
		
		if((uname.equals(hs.getUserName()))&&(pass.equals(hs.getPassword()))) {
			userIsValid=true;
			}
		}
		
		if(userIsValid==true) {
			HttpSession session = request.getSession();
			session.setAttribute("username", uname);
			response.sendRedirect("http://localhost:8080/WebAppHospitalManagement/index.jsp");
			
			} else {
			response.sendRedirect("http://localhost:8080/WebAppHospitalManagement/Welcome.jsp");
		}
		
	}

}