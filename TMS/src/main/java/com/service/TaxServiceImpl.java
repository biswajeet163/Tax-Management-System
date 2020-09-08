package com.service;

import org.springframework.stereotype.Service;

import com.model.UserClaim;

@Service
public class TaxServiceImpl implements TaxService {

	@Override
	public double calculateTax(UserClaim userClaim) {
		String exptyp = userClaim.getExpenseType();
		double amt = userClaim.getExpenseAmt();
		String ids = userClaim.getEmployeeId();
		
		double totalamt = 0.0;
		
//		System.out.println(ids);
//		System.out.println(exptyp);
//		System.out.println(amt);
//		
	
		if (exptyp.equals("MedicalExpense")) {
			
			if (amt <= 1000.0) {
				//System.out.println("Yse-------------");
				totalamt = amt * 0.15;
			}
				
			else if (amt > 1000.0 && amt <= 10000.0)
				totalamt = amt * 0.2;
			else if (amt > 10000.0)
				totalamt = amt * 0.25;
		}

		if (exptyp.equals("TravelExpense")) {
			if (amt <= 1000)
				totalamt = amt * 0.1;
			else if (amt > 1000 && amt <= 10000)
				totalamt = amt * 0.15;
			else if (amt > 10000)
				totalamt = amt * 0.2;
		}

		if (exptyp.equals("FoodExpense")) {
			if (amt <= 1000)
				totalamt = amt * 0.05;
			else if (amt > 1000 && amt <= 10000)
				totalamt = amt * 0.1;
			else if (amt > 10000)
				totalamt = amt * 0.15;
		}
		
		//System.out.println(totalamt);
		return totalamt;
	}


}