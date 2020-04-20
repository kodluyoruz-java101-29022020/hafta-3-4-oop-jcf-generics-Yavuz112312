package com.account.management;


import java.util.Set;
import java.util.TreeSet;

import com.exception.management.InvalidAuthenticationException;

public class AccountManager {
	
	public Set<Account> accountSet;

	private static TreeSet<Account> accountList;
	
	public AccountManager(Set<Account> accountSet) {
		this.accountSet = accountSet;
	}

	public static TreeSet<Account> getAccountList() {
		return accountList;
	}

	public void setAccountList(TreeSet<Account> accountList) {
		this.accountList = accountList;
	}

	public Account loginControl(String email, String password) {
		for (Account account : accountList) {
			if (account != null) {
				try {
					account.login(email, password);
				} catch (InvalidAuthenticationException exception) {
					System.out.println(AuthenticationStatus.FAIL.getCode());
				}

			}
		}
		return null;
	}

}
