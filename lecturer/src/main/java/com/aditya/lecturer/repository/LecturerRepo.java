package com.aditya.lecturer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aditya.lecturer.entity.Lecturer;


public interface LecturerRepo extends JpaRepository<Lecturer,Integer> {

}