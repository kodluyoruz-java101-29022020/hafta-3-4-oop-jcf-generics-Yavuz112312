package com.account.management;

import java.util.TreeSet;

import com.exception.management.InvalidAuthenticationException;

public class AccountManager {

	private TreeSet<Account> accountList;

	public TreeSet<Account> getAccountList() {
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
