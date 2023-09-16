package com.aditya.insurance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="policy")
public class Policy {
	@Id
	int policyId;
	
	@Column(name="policyHolderName")
	String policyHolderName;
	
	@Column(name="address")
	String address;
	
	@Column(name="nomineeName")
	String nomineeName;
	
	@Column(name="totalAmount")
	double totalAmount;
	
	Policy(){}
	
	public Policy(int policyId, String policyHolderName, String address, String nomineeName, double totalAmount) {
		super();
		this.policyId=policyId;
		this.policyHolderName=policyHolderName;
		this.address=address;
		this.nomineeName=nomineeName;
		this.totalAmount=totalAmount;
	}
	//getter
	public int getpolicyId() {
		return policyId;
	}
	public String getpolicyHolderName() {
		return policyHolderName;
	}
	public String getaddress() {
		return address;
	}
	public String getnomineeName() {
		return nomineeName;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	
	
	//setter
	public void setPolicyId(int policyId) {
		this.policyId=policyId;
	}
	public void setPolicyHolderName(String policyHolderName) {
		this.policyHolderName=policyHolderName;
	}
	public void setAddress(String address) {
		this.address=address;
	}
	public void setNomineeName(String nomineeName) {
		this.nomineeName=nomineeName;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount=totalAmount;
	}
	
	@Override
	public String toString() {
		return "Insurance[Policy Id="+policyId+" Policy Holder Name="+policyHolderName+" Address="+address+" Nominee Name="+nomineeName+" Total Amount="+totalAmount+"]";
	}
	
}
