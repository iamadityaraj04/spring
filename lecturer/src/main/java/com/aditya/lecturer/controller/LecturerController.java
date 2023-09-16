package com.aditya.lecturer.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aditya.lecturer.entity.Lecturer;
import com.aditya.lecturer.repository.LecturerRepo;

@RestController
public class LecturerController {
	
	@Autowired
	LecturerRepo lecturerRepository;
	

	//hello program for lecturer application
	@GetMapping("/")
	public String hello() {
		return "Hello from lecturer application";
	}
	
	//get lecturer data by id
	@GetMapping("/getlec/{lecId}")
	public Optional<Lecturer> getLecById(@PathVariable int lecId) {
		Optional<Lecturer> lecData=lecturerRepository.findById(lecId);
		return lecData;
	}
	
	//get all lecturer
	@GetMapping("/getalllec")
	public List<Lecturer> getAllLecturer() {
		List<Lecturer> lecList=lecturerRepository.findAll();
		return lecList;
	}
	
	//insert lecturer
	@PostMapping("/insertlec")
	public String insertLecturerData(@RequestBody Lecturer lecObj ) {
		System.out.println("Data Received: "+lecObj);
		lecturerRepository.save(lecObj);
		return "Data inserted successfully...";
	}
	
	//delete lecturer
	@DeleteMapping(path="/deletelec/{lecId}")
	public String deleteLecturer(@PathVariable int lecId) {
		System.out.println("Details to be deleted. Id: "+lecId);
		lecturerRepository.deleteById(lecId);
		return "Deleted Sucessfully...";
	}
	
	//updating data
	@PutMapping(path="/updatelec")
	public String updateLecData(@RequestBody Lecturer lecObj) {
		Optional<Lecturer> lecObjOptional=lecturerRepository.findById(lecObj.getlecId());
		if(lecObjOptional.isPresent()) {
			Lecturer lecObjToUpdate=lecObjOptional.get();
			lecObjToUpdate.setLecName(lecObj.getLecName());
			lecObjToUpdate.setLecAge(lecObj.getLecAge());
			lecObjToUpdate.setLecDepartment(lecObj.getLecDepartment());
			lecObjToUpdate.setLecCourse(lecObj.getLecCourse());
			lecturerRepository.save(lecObjToUpdate);
			return "Data updated Successfully...";
		}else {
			return "Unable to updated Successfully...";
		}
	}
}
