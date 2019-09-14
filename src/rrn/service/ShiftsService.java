package rrn.service;

import java.text.SimpleDateFormat;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import rrn.dao.Dao;
import rrn.pojos.Nurse;
import rrn.pojos.Shift;

public class ShiftsService {

	static DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("dd/MM/yyyy HH");

	public static boolean isValidDate(String date) {

		try {
			DateTime.parse(date, dateTimeFormatter);
		} catch (Exception pe) {
			return false;
		}
		return true;

	}

	public static boolean isShiftEligible(Shift ss) {

		if (
				(isStartHourCorrect(ss)) 
				&& (isEndHourCorrect(ss)) 
				&& (saturdayShiftVerification(ss))
				&& (sundayShiftVerification(ss)) 
				&& (nightShiftVerification(ss))
				&& (workingDayMorningShiftVerification(ss)) 
				&& (workingDayAfternoonShiftVerification(ss))
				&& (maximumNrOfNursesPerShift(ss))
			) {
			
			return true;

		} else
			return false;
	}

	public static boolean isStartHourCorrect(Shift ss) {
		if (((DateTime.parse(ss.getStartDate(), dateTimeFormatter).getHourOfDay()) != 8)
				&& ((DateTime.parse(ss.getStartDate(), dateTimeFormatter).getHourOfDay()) != 14)
				&& ((DateTime.parse(ss.getStartDate(), dateTimeFormatter).getHourOfDay()) != 20)) {
			return false;
		} else
			return true;
	}

	public static boolean isEndHourCorrect(Shift ss) {
		if (((DateTime.parse(ss.getEndDate(), dateTimeFormatter).getHourOfDay()) != 8)
				&& ((DateTime.parse(ss.getEndDate(), dateTimeFormatter).getHourOfDay()) != 14)
				&& ((DateTime.parse(ss.getEndDate(), dateTimeFormatter).getHourOfDay()) != 20)) {
			return false;
		} else
			return true;
	}

	public static boolean saturdayShiftVerification(Shift ss) {
		if ((DateTime.parse(ss.getStartDate(), dateTimeFormatter).getHourOfDay() == 8)
				&& (DateTime.parse(ss.getStartDate(), dateTimeFormatter).getDayOfWeek() == 6)
				&& (DateTime.parse(ss.getEndDate(), dateTimeFormatter).getHourOfDay() != 20)) {
			return false;
		} else
			return true;
	}

	public static boolean sundayShiftVerification(Shift ss) {
		if ((DateTime.parse(ss.getStartDate(), dateTimeFormatter).getHourOfDay() == 8)
				&& (DateTime.parse(ss.getStartDate(), dateTimeFormatter).getDayOfWeek() == 7)
				&& (DateTime.parse(ss.getEndDate(), dateTimeFormatter).getHourOfDay() != 20)) {
			return false;
		} else
			return true;
	}

	public static boolean nightShiftVerification(Shift ss) {
		if ((DateTime.parse(ss.getStartDate(), dateTimeFormatter).getHourOfDay() == 20)
				&& (DateTime.parse(ss.getEndDate(), dateTimeFormatter).getHourOfDay() != 8)) {
			return false;
		} else
			return true;
	}

	public static boolean workingDayMorningShiftVerification(Shift ss) {
		if ((((DateTime.parse(ss.getStartDate(), dateTimeFormatter).getDayOfWeek() == 1)
				|| (DateTime.parse(ss.getStartDate(), dateTimeFormatter).getDayOfWeek() == 2)
				|| (DateTime.parse(ss.getStartDate(), dateTimeFormatter).getDayOfWeek() == 3)
				|| (DateTime.parse(ss.getStartDate(), dateTimeFormatter).getDayOfWeek() == 4)
				|| (DateTime.parse(ss.getStartDate(), dateTimeFormatter).getDayOfWeek() == 5))
				&& (DateTime.parse(ss.getStartDate(), dateTimeFormatter).getHourOfDay() == 8))
				&& (DateTime.parse(ss.getEndDate(), dateTimeFormatter).getHourOfDay() != 14)) {
			return false;
		} else
			return true;
	}

	public static boolean workingDayAfternoonShiftVerification(Shift ss) {
		if ((((DateTime.parse(ss.getStartDate(), dateTimeFormatter).getDayOfWeek() == 1)
				|| (DateTime.parse(ss.getStartDate(), dateTimeFormatter).getDayOfWeek() == 2)
				|| (DateTime.parse(ss.getStartDate(), dateTimeFormatter).getDayOfWeek() == 3)
				|| (DateTime.parse(ss.getStartDate(), dateTimeFormatter).getDayOfWeek() == 4)
				|| (DateTime.parse(ss.getStartDate(), dateTimeFormatter).getDayOfWeek() == 5))
				&& (DateTime.parse(ss.getStartDate(), dateTimeFormatter).getHourOfDay() == 14))
				&& (DateTime.parse(ss.getEndDate(), dateTimeFormatter).getHourOfDay() != 20)) {
			return false;
		} else
			return true;
	}

	public static boolean maximumNrOfNursesPerShift(Shift ss) {
		Dao d = new Dao();
		List<Nurse> nursesList = d.getNursesList();
		List<Shift> previousShifts = Dao.getAlreadySavedShifts();
		int nrOfNursesPerShift = 0;
		for (Shift s : previousShifts) {
			if ((ss.getStartDate().equals(s.getStartDate())) && (ss.getEndDate().equals(s.getEndDate())))
				nrOfNursesPerShift++;
		}

		if ((nrOfNursesPerShift >= 6) && (DateTime.parse(ss.getStartDate(), dateTimeFormatter).getDayOfWeek() <= 5)
				&& (DateTime.parse(ss.getStartDate(), dateTimeFormatter).getHourOfDay() == 8)) {
			return false;
		}

		if ((nrOfNursesPerShift >= 2) && (DateTime.parse(ss.getStartDate(), dateTimeFormatter).getDayOfWeek() <= 5)
				&& (DateTime.parse(ss.getStartDate(), dateTimeFormatter).getHourOfDay() == 14)) {
			return false;
		}

		if ((nrOfNursesPerShift >= 2) && (DateTime.parse(ss.getStartDate(), dateTimeFormatter).getDayOfWeek() > 5)) {
			return false;
		}

		if ((nrOfNursesPerShift >= 2) && (DateTime.parse(ss.getStartDate(), dateTimeFormatter).getHourOfDay() == 20)) {
			return false;
		}

		return true;

	}

}
