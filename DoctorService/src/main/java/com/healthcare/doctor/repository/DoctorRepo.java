package com.healthcare.doctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthcare.doctor.model.Doctor;

public interface DoctorRepo extends JpaRepository<Doctor,Integer>{

}
