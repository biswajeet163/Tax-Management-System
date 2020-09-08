package com.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserClaim {
	
	private String expenseType;
	@Min(value = 0, message = "{error.expenseAmount.negative}")
	private double expenseAmt;
	@NotNull(message = "{error.employeeId}")
	@Size(min=5, message="{error.employeeId.format}")
	private String employeeId;

	public String getExpenseType() {
		return expenseType;
	}

	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}

	public double getExpenseAmt() {
		return expenseAmt;
	}

	public void setExpenseAmt(double expenseAmt) {
		this.expenseAmt = expenseAmt;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	


}