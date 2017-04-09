package com.vodafone.test.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)


public class Voucher {

	@JsonProperty("voucher-number")
	private String voucherNumber; 
	
	@JsonProperty("voucher-value")
	private int vaoucherValue;
	
	@JsonProperty("currency")
	private String currency;
	
	@JsonProperty("firstname")
	private String firstName;
	
	@JsonProperty("lastname")
	private String lastName;
	
	
	
	public String getVoucherNumber() {
		return voucherNumber;
	}
	public void setVoucherNumber(String voucherNumber) {
		this.voucherNumber = voucherNumber;
	}
	public int getVaoucherValue() {
		return vaoucherValue;
	}
	public void setVaoucherValue(int vaoucherValue) {
		this.vaoucherValue = vaoucherValue;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
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
	public Voucher(){
		
	}
	public Voucher(String voucherNumber, int vaoucherValue, String currency,
			String firstName, String lastName) {
		
		this.voucherNumber = voucherNumber;
		this.vaoucherValue = vaoucherValue;
		this.currency = currency;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	@Override
	public String toString() {
		return "Voucher [voucherNumber=" + voucherNumber  +" "+firstName+" "+lastName+"]";
	}
	
	
}
