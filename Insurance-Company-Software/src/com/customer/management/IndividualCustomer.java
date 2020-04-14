package com.customer.management;

import java.util.ArrayList;

import com.account.management.Account;
import com.insurance.management.Insurance;

public class IndividualCustomer extends Account{

	public IndividualCustomer(User user, ArrayList<Insurance> insuranceList) {
		super(user, insuranceList);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected double addProfit(double insurancePrice) {
		double totalPrice;
		totalPrice = insurancePrice + (insurancePrice * 0.70);
		return totalPrice;	}

}
