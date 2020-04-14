package com.main;

import java.util.Scanner;

import com.account.management.Account;
import com.account.management.AccountManager;
import com.account.management.AuthenticationStatus;
import com.exception.management.InvalidAuthenticationException;




public class Main {
	
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		
	}
	

	
	private static Account login(AccountManager accountManager, Account account) throws InvalidAuthenticationException {
		String email, password;

		System.out.print("\nPlease enter your e-mail:");
		email = scanner.nextLine();

		System.out.print("Please enter your password:");
		password = scanner.nextLine();

		
		account = accountManager.loginControl(email, password);
		
		return account;
		
	}
	
}
