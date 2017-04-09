package com.vodafone.test.service;

import java.util.List;

import com.vodafone.test.json.CreditVoucher;
import com.vodafone.test.model.Reward;

public interface CreditProcessed {

	public List<Reward>processedForReward(CreditVoucher creditVoucher);
}
