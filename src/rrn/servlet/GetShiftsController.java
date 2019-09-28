package rrn.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;

import com.google.protobuf.TextFormat.ParseException;

import rrn.dao.Dao;
import rrn.pojos.Nurse;
import rrn.pojos.Shift;
import rrn.service.ShiftsService;

public class GetShiftsController extends HttpServlet {
	
	private int nID; //id-ul asistentei solicitate pt tura
	private String startDate; 
	private String endDate;
	private boolean isNewShiftEligible; 
	private boolean areDatesValid;
	private Shift newShift;
	
	public int getnID() {
		return nID;
	}

	public String getStartDate() {
		return startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Dao dao = new Dao();
		 List<Nurse> listOfNurses = dao.getNursesList();
		 int nrOfNurses = listOfNurses.size();
		nID = Integer.parseInt(request.getParameter("nurseID"));
		startDate = request.getParameter("shiftStartDate");
		endDate = request.getParameter("shiftEndDate");
		
		if((nID<=0)||(nID>nrOfNurses)) {
			response.sendRedirect("notValidId.jsp");
		}
		
		if ((ShiftsService.isValidDate(startDate))&&(ShiftsService.isValidDate(endDate))) {
			areDatesValid = true;	
		}
		
		if(areDatesValid==true) {
			newShift = new Shift();
			newShift.setNurseID(nID);
			newShift.setStartDate(startDate);
			newShift.setEndDate(endDate);
			isNewShiftEligible = ShiftsService.isShiftEligible(newShift);
		}
		
		 if ((areDatesValid==true)&&(isNewShiftEligible)) {	
			
			dao.saveShift(newShift);
			request.setAttribute("newShift", newShift);
			RequestDispatcher rd = request.getRequestDispatcher("showNewShiftDetails.jsp");
			rd.forward(request, response);
			
		} 

		 else if(areDatesValid==false){
		  
		 response.sendRedirect("notValidDate.jsp");
		 
		 } else if((areDatesValid==true)&&(!isNewShiftEligible)) {
		  
		 response.sendRedirect("notEligibleShift.jsp");
		  
		 }
	}
	
}