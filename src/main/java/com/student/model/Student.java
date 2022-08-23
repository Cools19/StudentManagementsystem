package com.student.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String firstName;
	private String LastName;
	private String studentclass;
	private String subject;
	private String address;
	private String dob;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getStudentclass() {
		return studentclass;
	}
	public void setStudentclass(String studentclass) {
		this.studentclass = studentclass;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public Student(int id, String firstName, String lastName, String studentclass, String subject, String address,
			String dob) {
		super();
		this.id = id;
		this.firstName = firstName;
		LastName = lastName;
		this.studentclass = studentclass;
		this.subject = subject;
		this.address = address;
		this.dob = dob;
	}
	public Student() {
		super();
	}
}

	