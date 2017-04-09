package com.vodafone.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.vodafone.test.json.CreditVoucher;
import com.vodafone.test.model.Credit;
import com.vodafone.test.model.Reward;
import com.vodafone.test.service.CreditProcessed;

@Controller
@RequestMapping("/vodafone")
public class VodafoneController {

	private Logger log = Logger.getLogger(VodafoneController.class);
	
	@Autowired
	CreditProcessed creditProcessed;
	
	@RequestMapping(value = "/getReward")	
	public @ResponseBody List<Credit> getReward(){
		
		
		System.out.println("tecs");
		List<Credit>rl = new ArrayList<Credit>();
		Credit rb = new Credit("wd", 233, "jdsh", "dsn");
		rl.add(rb);
	return rl;
		
	}
	@RequestMapping(value = "/getRewardsByPerson", method = RequestMethod.POST, consumes={"application/json"}, produces={"application/json"}, headers="Accept=application/json")	
	public @ResponseBody List<Reward> getRewardsByPerson(@RequestBody Object object,BindingResult bindingResult){
		
		 ObjectMapper mapper=new ObjectMapper();
		 mapper.enable(SerializationFeature.INDENT_OUTPUT);
		 TypeReference<CreditVoucher> mapType = new TypeReference<CreditVoucher>() {};
		 String json = null;
		 CreditVoucher creditVoucher = null;
	    try {
	    	 json = mapper.writeValueAsString(object);
	    	 creditVoucher = mapper.readValue(json, mapType);
		} catch (IOException e) {
			
			e.printStackTrace();
		
		}
		
	    List<Reward> rewardList = creditProcessed.processedForReward(creditVoucher);
	    
	return rewardList;
		
	}
}
