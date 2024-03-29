package com.spring.orm.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;

@Entity
@Table(name="student_details")
//@Table(name = "student_details")
public class Student {
	@Id
	@Column(name = "student_id")
	private int studentID;
	@Column(name = "student_name")
	private String studentName;
	@Column(name = "student_city")
	private String city;

	// CONSTRUCTORS
	public Student(int studentID, String studentName, String city) {
		super();
		this.studentID = studentID;
		this.studentName = studentName;
		this.city = city;
	}

	// DEFAULT CONSTRUCTOR
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	//GETTERS AND SETTERS
	/**
	 * @return the studentID
	 */
	public int getStudentID() {
		return studentID;
	}

	/**
	 * @param studentID the studentID to set
	 */
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	/**
	 * @return the studentName
	 */
	public String getStudentName() {
		return studentName;
	}

	/**
	 * @param studentName the studentName to set
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	

}
