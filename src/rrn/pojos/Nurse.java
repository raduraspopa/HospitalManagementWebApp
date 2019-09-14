package rrn.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nurses")
public class Nurse {

	@Id
	@Column(name = "Nurse_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	
	@Column(name = "Nurse_firstName")
	private String firstName;
	
	@Column(name = "Nurse_lastName")
	private String lastName;
	
}

