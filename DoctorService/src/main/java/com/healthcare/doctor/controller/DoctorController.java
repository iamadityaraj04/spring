package com.healthcare.doctor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.doctor.model.Doctor;
import com.healthcare.doctor.services.DoctorService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class DoctorController {
	
	@Autowired
	DoctorService doctorService;
	
	@GetMapping
	public String hello() {
		return "Hello from Health Care Management Application :)";
	}
	
	//getAllDoctors
	@GetMapping("/doctors")
	public List<Doctor> allDoctors(){
		return doctorService.getAllDoctors();
	}
	
	//getDoctorById
	@GetMapping("/doctor/{id}")
	public ResponseEntity<Doctor> getDocById(@PathVariable(value="id") int id){
		
		try {
			Doctor doctor=doctorService.getDoctorById(id);
			return new ResponseEntity<Doctor>(doctor,HttpStatus.OK);
		}
		catch(Exception ex) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	//add new doctor
	@PostMapping("/doctor/insert")
	public Doctor insertData(@RequestBody Doctor docObj) {
		return doctorService.addDoctor(docObj);
	}
	
	//update doctor
	@PutMapping("/doctor/update/{id}")
	public ResponseEntity<Doctor> updateData(@PathVariable(value="id") int id, @RequestBody Doctor docObj) {
			
		try {
		Doctor updateDoctorObj=doctorService.getDoctorById(id);
		updateDoctorObj.setName(docObj.getName());
		updateDoctorObj.setEmail(docObj.getEmail());
		updateDoctorObj.setGender(docObj.getGender());
		updateDoctorObj.setDob(docObj.getDob());
		updateDoctorObj.setSpecialization(docObj.getSpecialization());
			
		Doctor updatedData=doctorService.updateDoctor(updateDoctorObj);
		return new ResponseEntity<Doctor>(updatedData,HttpStatus.OK);
		}
		catch(Exception ex) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
			
	}
	
	//delete doctor
	@DeleteMapping("/doctor/delete/{id}")
	public void deleteData(@PathVariable int id) {
		doctorService.deleteDoctor(id);
	}
}
