package com.vodafone.test.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Reward {

	private List<String> credit;
	private List<String> voucher;
	private String firstName;
	private String lastName;
	
	
	public Reward() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Reward(List<String> credit, List<String> voucher, String firstName,
			String lastName) {
		super();
		this.credit = credit;
		this.voucher = voucher;
		this.firstName = firstName;
		this.lastName = lastName;
	}


	public List<String> getCredit() {
		return credit;
	}
	public void setCredit(List<String> credit) {
		this.credit = credit;
	}
	public List<String> getVoucher() {
		return voucher;
	}
	public void setVoucher(List<String> voucher) {
		this.voucher = voucher;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	
}
