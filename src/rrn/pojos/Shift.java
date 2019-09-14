package rrn.pojos;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shifts")
public class Shift {
	
	@Id
	@Column(name = "shift_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int shiftId;
	
	@Column(name = "nurse_Id")
	int nurseID;
	
	@Column(name = "start_date")
	String startDate;
	
	@Column(name = "end_date")
	String endDate;
	
	public int getNurseID() {
		return nurseID;
	}
	public void setNurseID(int nurseID) {
		this.nurseID = nurseID;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	
	
}

