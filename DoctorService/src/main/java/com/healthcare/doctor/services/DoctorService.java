package com.healthcare.doctor.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.healthcare.doctor.model.Doctor;
import com.healthcare.doctor.repository.DoctorRepo;

@Component
@Service
public class DoctorService {
	
	@Autowired
	DoctorRepo doctorRepository;

	//getAllDoctors
	public List<Doctor> getAllDoctors() {
		return doctorRepository.findAll();
	}
	
	
	//getDoctorById
	public Doctor getDoctorById(int id) {
		return doctorRepository.findById(id).get();
		
	}
	
	//addDoctor
	public Doctor addDoctor(Doctor newDoctor) {
		doctorRepository.save(newDoctor);
		return newDoctor;
	}
	
	//updateDoctor
	public Doctor updateDoctor(Doctor updateDoctor) {
		doctorRepository.save(updateDoctor);
		return updateDoctor;
	}
	
	//deleteDoctor
		public void deleteDoctor(int id) {
			doctorRepository.deleteById(id);
		}
}
