package com.vodafone.test.serviceImpl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.vodafone.test.json.CreditVoucher;
import com.vodafone.test.model.Credit;
import com.vodafone.test.model.Reward;
import com.vodafone.test.model.Voucher;
import com.vodafone.test.service.CreditProcessed;


@Service
public class CreditProcessedImpl implements CreditProcessed {

	@Override
	public List<Reward> processedForReward(CreditVoucher creditVoucher) {
		List<Reward> rewardList = new ArrayList<Reward>();
		
		List<Credit> creditList = creditVoucher.getCredit();
		List<Voucher> voucherList = creditVoucher.getVoucher();
		
		Set<String> nameSet = getNameSet(creditList, voucherList );
		if(voucherList!= null && creditList != null && voucherList.size() > creditList.size()){
			
			creditList.sort( Comparator.comparing(Credit::getFirstName).thenComparing(Credit::getLastName)  );
			voucherList.sort( Comparator.comparing(Voucher::getFirstName).thenComparing(Voucher::getLastName)  );
			
			for(String nm :nameSet){
				Reward rw = new Reward();
				
				String [] name = nm.split("_");
				
				rw.setCredit(getCreditList(creditList, name[0], name[1]));
				rw.setVoucher(getVoucherList(voucherList, name[0],name[1]));
				rw.setFirstName(name[0]);
				rw.setLastName(name[1]);
				
				rewardList.add(rw);
			}
			System.out.println(creditList);
			System.out.println(voucherList);
		}
		return rewardList;
	}






	private List<String> getCreditList(List<Credit> creditList, String firstName, String lastName) {
	
		List<String> crList = new ArrayList<>();
		
		for(Credit cr : creditList){
			if(cr.getFirstName().equals(firstName) && cr.getLastName().equals(lastName)){
				crList.add(cr.getCreditId());
			}
		}
		return crList;
	}


	private List<String> getVoucherList(List<Voucher> voucherList, String firstName, String lastName) {
		
		List<String> vrList = new ArrayList<>();
		
		for(Voucher cr : voucherList){
			if(cr.getFirstName().equals(firstName) && cr.getLastName().equals(lastName)){
				vrList.add(cr.getVoucherNumber());
			}
		}
		return vrList;
	}




	private Set<String> getNameSet(List<Credit> creditList, List<Voucher> voucherList) {
		Set< String> nameSet = new HashSet<>();
		
		for(Credit cr : creditList){
			String name = cr.getFirstName().trim()+"_"+cr.getLastName().trim();
			nameSet.add(name);
		}
		
		for(Voucher vc : voucherList){
			String name = vc.getFirstName().trim()+"_"+vc.getLastName().trim();
			nameSet.add(name);
		}
		
		return nameSet;
	}

}
