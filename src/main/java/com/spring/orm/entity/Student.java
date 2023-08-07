package com.spring.orm.entity;

import javax.persistence.*;

@Entity
@Table(name="student_details")
public class Student {
	
	@Id
	@Column(name="student_Id")
	private int studentId;
	@Column(name="student_Name")
	private String studentName;
	@Column(name="student_City")
	private String studentCity;
	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}


	


	public Student(int studentId, String studentName, String studentCity) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentCity = studentCity;
	}





	public int getStudentId() {
		return studentId;
	}


	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}


	public String getStudentName() {
		return studentName;
	}


	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	public String getStudentCity() {
		return studentCity;
	}


	public void setStudentCity(String studentCity) {
		this.studentCity = studentCity;
	}
	
	
	
	

}
