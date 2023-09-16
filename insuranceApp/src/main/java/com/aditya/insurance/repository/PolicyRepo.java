package com.aditya.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aditya.insurance.entity.Policy;

public interface PolicyRepo extends JpaRepository<Policy,Integer>{

}
