package com.aditya.app.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	@Id
	int id;
	
	@Column(name="name")
	String name;
	
	@Column(name="dept")
	String dept;
	
	@Column(name="designation")
	String designation;
	
	Employee(){}
	
	public Employee(int id, String name, String dept, String designation) {
		super();
		this.id=id;
		this.name=name;
		this.dept=dept;
		this.designation=designation;
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDept() {
		return dept;
	}
	public String getDesignation() {
		return designation;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setDept(String dept) {
		this.dept=dept;
	}
	public void setDesignation(String designation) {
		this.designation=designation;
	}
	
	@Override
	public String toString() {
		return "Employee[id="+id+" name="+name+" dept="+dept+" designation="+designation+"]";
	}
	
}
