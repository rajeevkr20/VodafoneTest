package com.vodafone.test.json;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vodafone.test.model.Credit;
import com.vodafone.test.model.Voucher;
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreditVoucher {

	private List<Credit> credit = new ArrayList<Credit>();
	private List<Voucher> voucher = new ArrayList<>();
	
	
	public List<Credit> getCredit() {
		return credit;
	}
	public void setCredit(List<Credit> credit) {
		this.credit = credit;
	}
	public List<Voucher> getVoucher() {
		return voucher;
	}
	public void setVoucher(List<Voucher> voucher) {
		this.voucher = voucher;
	}
	
}
