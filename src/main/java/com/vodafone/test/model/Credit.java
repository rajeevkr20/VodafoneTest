package com.vodafone.test.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Rajeev
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Credit {

	@JsonProperty("credit-id")
	private String creditId;
	
	@JsonProperty("points")
	private int point;
	
	@JsonProperty("firstname")
	private String firstName;
	
	@JsonProperty("lastname")
	private String lastName;
	
	public String getCreditId() {
		return creditId;
	}
	public void setCreditId(String creditId) {
		this.creditId = creditId;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
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
	public Credit(String creditId, int point, String firstName, String lastName) {
		super();
		this.creditId = creditId;
		this.point = point;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public Credit(){
		
	}
	@Override
	public String toString() {
		return "Credit [creditId=" + creditId +" "+firstName+" "+lastName+ "]";
	}
	
	
}
