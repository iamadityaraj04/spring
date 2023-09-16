package com.aditya.lecturer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="lecturer")
public class Lecturer {

	//schema
	@Id
	int lecId;
	
	@Column(name="lecName")
	String lecName;
	
	@Column(name="lecAge")
	int lecAge;
	
	@Column(name="lecDepartment")
	String lecDepartment;
	
	@Column(name="lecCourse")
	String lecCourse;
	
	Lecturer(){}
	
	public Lecturer(int lecId, String lecName, int lecAge, String lecDepartment, String lecCourse) {
		super();
		this.lecId=lecId;
		this.lecName=lecName;
		this.lecAge=lecAge;
		this.lecDepartment=lecDepartment;
		this.lecCourse=lecCourse;
	}
	
	//getter methods
	
	
	public int getlecId() {
		return lecId;
	}
	public String getLecName() {
		return lecName;
	}
	public int getLecAge() {
		return lecAge;
	}
	public String getLecDepartment() {
		return lecDepartment;
	}
	public String getLecCourse() {
		return lecCourse;
	}
	
	
	//setter methods
	
	public void setLecId(int lecId) {
		this.lecId=lecId;
	}
	public void setLecName(String lecName) {
		this.lecName=lecName;
	}
	public void setLecAge(int lecAge) {
		this.lecAge=lecAge;
	}
	public void setLecDepartment(String lecDepartment) {
		this.lecDepartment=lecDepartment;
	}
	public void setLecCourse(String lecCourse) {
		this.lecCourse=lecCourse;
	}
	
	//display
	@Override
	public String toString() {
		return "Lecturer: [Lecturer Id="+lecId+" Lecturer Name="+lecName+" Lecturer Age="+lecAge+" Lecturer Department="+lecDepartment+" Lecturer Course="+lecCourse+"]";
	}
	
}
