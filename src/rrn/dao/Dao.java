package rrn.dao;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.transform.Transformers;

import rrn.pojos.HeadStaff;
import rrn.pojos.Nurse;
import rrn.pojos.Shift;

public class Dao {
public Dao() {}
	static Configuration con = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Nurse.class)
								.addAnnotatedClass(Shift.class)
								.addAnnotatedClass(HeadStaff.class);
	
	static SessionFactory sf = con.buildSessionFactory();
	
	public List<Nurse> getNursesList() {

		List<Nurse> nursesList = new ArrayList();

		Session sessionObj = sf.openSession();
		nursesList = (List<Nurse>) sessionObj.createQuery("FROM Nurse").list();
		sessionObj.close();

		return nursesList;
	}
	
	public static Nurse getNurseById(int nurseId) {

		Session session = sf.openSession();
		Nurse n = (Nurse) session.get(Nurse.class, nurseId);
		session.close();

		return n;

	}

	public static List<Shift> getAlreadySavedShifts() {

		List<Shift> shiftsList = new ArrayList();

		Session sessionObj = sf.openSession();
		shiftsList = (List<Shift>) sessionObj.createQuery("FROM Shift").list();
		sessionObj.close();

		return shiftsList;
	}

	public static void saveShift(Shift s) {

		Session sessionObj = sf.openSession();
		try {
			sessionObj.beginTransaction();
			sessionObj.save(s);
			sessionObj.getTransaction().commit();
		} catch (Exception sqlException) {
			System.out.println("Nu se poate salva tura");
			sqlException.printStackTrace();
			sessionObj.getTransaction().rollback();
		} finally {
			sessionObj.close();
		}
	}
	
	public static List<HeadStaff> getHeadStaffList() {

		List<HeadStaff> HeadStaffList = new ArrayList();

		Session sessionObj = sf.openSession();
		HeadStaffList = (List<HeadStaff>) sessionObj.createQuery("FROM HeadStaff").list();
		sessionObj.close();

		return HeadStaffList;
	}
	
}