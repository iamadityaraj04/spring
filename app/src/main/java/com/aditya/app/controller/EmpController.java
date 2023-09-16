package com.aditya.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aditya.app.Entity.Employee;
import com.aditya.app.repository.EmployeeRepo;


@RestController
public class EmpController {
	@Autowired
	EmployeeRepo empRepository;

	//getting all details
	@GetMapping(path="/getAllEmployees")
	public List<Employee> getAllEmployees(){
		List<Employee> empList=empRepository.findAll();
		return empList;
	}
	//getting all details sorted by name
		@GetMapping(path="/getAllEmployeesSortedByName")
		public List<Employee> getAllEmployeesSortedByName(){
			return empRepository.getAllEmployeesSortedByName();
		}
	
	//inserting data
	@PostMapping(path="/insertData")
	public String insertEmp(@RequestBody Employee empObj) {
		
		System.out.println("Data received: "+empObj);
		empRepository.save(empObj);
		return "Inserted Sucessfully...";
	}
	
	//deleting data
	@DeleteMapping(path="/deleteData/{id}")
	public String deleteEmp(@PathVariable int id) {
		
		System.out.println("Details to be deleted. Id: "+id);
		empRepository.deleteById(id);
		return "Deleted Sucessfully...";
	}
	
	//updating data
	@PutMapping(path="/updateData")
	public String updateEmp(@RequestBody Employee empObj) {
		Optional<Employee> empObjOptional=empRepository.findById(empObj.getId());
		if(empObjOptional.isPresent()) {
			Employee empObjToUpdate=empObjOptional.get();
			empObjToUpdate.setName(empObj.getName());
			empObjToUpdate.setDept(empObj.getDept());
			empObjToUpdate.setDesignation(empObj.getDesignation());
			empRepository.save(empObjToUpdate);
			return "Data updated Successfully...";
		}else {
			return "Unable to updated Successfully...";
		}
	}
	
	@RequestMapping("/welcome")
	public String welcome() {
		return "Hi! Welcome to your first spring application.....";
	}
	
	@RequestMapping ("/login")
	public String login (@RequestParam String uid, @RequestParam String pwd){
		System.out.println("Data: UserId: "+uid+" Password: "+pwd);
		String strReturn="";
		
		if(uid.equals("Aditya")&& pwd.equals("admin")) {
			strReturn="Valid User! Go ahead...";
		}
		else {
			strReturn="Invalid user!";
		}
		return strReturn;
		
	}
	
	@GetMapping(path="/getEmployee")
	public Employee getEmployee() {
		Employee empObj=new Employee(111,"Aditya Raj","IT","Software Development Engineer");
		return empObj;
	}
}
