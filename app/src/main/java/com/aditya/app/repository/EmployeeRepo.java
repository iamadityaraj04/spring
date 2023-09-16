package com.aditya.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aditya.app.Entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	
	@Query(value="Select * from employee Order BY name",nativeQuery=true)
	public List<Employee> getAllEmployeesSortedByName();
}