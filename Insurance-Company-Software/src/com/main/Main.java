package com.main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import com.account.management.Account;
import com.account.management.AccountManager;
import com.adress.management.Adress;
import com.adress.management.AdressManager;
import com.adress.management.BusinessAdress;
import com.adress.management.HomeAdress;
import com.customer.management.EnterpriseCustomer;
import com.customer.management.IndividualCustomer;
import com.customer.management.User;
import com.exception.management.InvalidAuthenticationException;
import com.insurance.management.Insurance;

public class Main {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		
		AccountManager accountManager = new AccountManager(null);
		
		
		createCustomer();
		showMenu();
		
		while(true) {
			
			int choice = makeProcessChoice();
			
			if(choice == 10) {
				break;
			}
			
			switch (choice) {
				case 1:
					
					break;
				/*case 2:
					showEmployeeProfile(employeeService, salaryService);
					System.out.println();
					break;
				case 3:
					insertEmployee(employeeService);
					System.out.println();
					break;
				case 4:
					updateEmployee(employeeService);
					System.out.println();
					break;
				case 5:
					deleteEmployee(employeeService);
					System.out.println();
					break;
				case 6:
					showMenu();
					System.out.println();
					break;
				case 7:
					// burada aktif yöneticileri listeleyen bir fonksiyon yazmalısınız.
					break;
				case 8:
					// burada tüm departmanları listeleyiniz.
					break;
				case 9:
					draftEmployeeProfileOperations(employeeService, salaryService);
					break;*/
			}
			
		}
		
	}
	
	private static void showMenu() {
		
		System.out.println("1- Insert Customer ");
		System.out.println("2- Çalışan profili sorgulama ");
		System.out.println("3- Yeni çalışan ekleme ");
		System.out.println("4- Çalışan verilerini güncelleme ");
		System.out.println("5- Çalışan silme ");
		System.out.println("6- Menüyü tekrar yazdır ");
		System.out.println("7- Aktif yöneticilik yapanları listele ");
		System.out.println("8- Departmanları listele ");
		System.out.println("9- Geçici profil işlemleri ");
		System.out.println("10- Çıkış ");
		
	}

	public static int makeProcessChoice() {

		System.out.println("İşlem tercihinizi yapınız...");
		int choice = scanner.nextInt();
		return choice;
	}

	public static void insertCustomer() {

		ArrayList<Adress> userAdress = new ArrayList<Adress>();

		System.out.println("Add Customer Info:");

		System.out.println("Name");
		String name = scanner.nextLine();

		System.out.println("Last Name");
		String lastName = scanner.nextLine();

		System.out.println("Email");
		String email = scanner.nextLine();

		System.out.println("Password");
		String password = scanner.nextLine();

		System.out.println("Job");
		String job = scanner.nextLine();

		System.out.println("Age");
		int age = scanner.nextInt();

		User user = new User(name, lastName, email, password, job, age, userAdress);

		System.out.println("Choose Customer Type");
		System.out.println("1- Individual");
		System.out.println("2- Enterprice");
		System.out.println("**************");
		System.out.println("Choise 1 or 2 : ");
		int choose = scanner.nextInt();

		
		if (choose == 1) {

			System.out.println("Customer's Home Adress Info:");

			System.out.println("Country");
			String country = scanner.nextLine();

			System.out.println("City");
			String city = scanner.nextLine();

			System.out.println("Street");
			String street = scanner.nextLine();

			System.out.println("Number");
			int number = scanner.nextInt();

			System.out.println("PostCode");
			int postCode = scanner.nextInt();

			AdressManager.addAdress(user, new HomeAdress(country, city, street, number, postCode));
			Account account = new IndividualCustomer(user, new ArrayList<Insurance>());
			
			System.out.println("*********************************");
			System.out.println("Saved!");

		} else if (choose == 2) {

			System.out.println("Customer's Business Adress Info:");

			System.out.println("Country");
			String country = scanner.nextLine();

			System.out.println("City");
			String city = scanner.nextLine();

			System.out.println("Street");
			String companyName = scanner.nextLine();

			System.out.println("Number");
			int number = scanner.nextInt();

			System.out.println("PostCode");
			int postCode = scanner.nextInt();

			AdressManager.addAdress(user, new BusinessAdress(country, city, companyName, postCode));
			Account account = new EnterpriseCustomer(user, new ArrayList<Insurance>());

			System.out.println("*********************************");
			System.out.println("Saved!");
			
		} else {
			System.out.println("Please enter 1 or 2");
		}

	}

	public static AccountManager createCustomer() {
		Set<Account> accountSet = new TreeSet<Account>();
		AccountManager accountManager = new AccountManager(accountSet);
		insertCustomer();
		return accountManager;

	}

	/*
	 * private static Account login(AccountManager accountManager, Account account)
	 * throws InvalidAuthenticationException { String email, password;
	 * 
	 * System.out.println("Email :"); email = scanner.nextLine();
	 * 
	 * System.out.println("Password :"); password = scanner.nextLine();
	 * 
	 * 
	 * account = accountManager.loginControl(email, password);
	 * 
	 * return account;
	 * 
	 * }
	 */

}
