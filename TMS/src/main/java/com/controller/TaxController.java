package com.controller;
//Hello

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.UserClaim;
import com.service.TaxService;

@Controller
public class TaxController {

	@Autowired
	private TaxService taxService;
	@Autowired
	private Validator validator;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String claimPage(@ModelAttribute("userClaim") UserClaim userClaim) {
		return "taxclaim";
	}

	@RequestMapping(value = "/calculateTax", method = RequestMethod.GET)
	public String calculateTax(@ModelAttribute("userClaim") @Valid UserClaim userClaim, BindingResult result,
			ModelMap map) {

		if (result.hasErrors()) {
			return "taxclaim";
		}

		double totalTax = taxService.calculateTax(userClaim);
		
		

		map.addAttribute("types", userClaim.getExpenseType());
		map.addAttribute("amounts", userClaim.getExpenseAmt());
		map.addAttribute("costs", totalTax);// add type // tax claim // and amount to be paid
		return "result";
	}

	@ModelAttribute("expenseList")
	public List<String> populateExpense() {
		List<String> li = new ArrayList<String>();

		li.add("MedicalExpense");
		li.add("TravelExpense");
		li.add("FoodExpense");

		return li;
	}
}