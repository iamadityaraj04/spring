package com.aditya.insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aditya.insurance.entity.Policy;
import com.aditya.insurance.repository.PolicyRepo;

@RestController
public class InsuranceController {
	
	@Autowired
	PolicyRepo policyRepository;
	@GetMapping("/")
	public String hello() {
		return "Hello from insurance application";
	}
	
	@GetMapping("/getallpolicies")
	public List<Policy> getAllPolicies() {
		List<Policy> policyList=policyRepository.findAll();
		return policyList;
	}
	
	@PostMapping("/insertpolicydata")
	public String insertPolicyData(@RequestBody Policy policyObj) {
		System.out.println("Data Received: "+policyObj);
		policyRepository.save(policyObj);
		return "Data inserted successfully...";
	}
}
