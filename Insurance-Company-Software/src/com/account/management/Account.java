package com.account.management;

import java.util.ArrayList;
import java.util.List;

import com.adress.management.Adress;
import com.customer.management.User;
import com.exception.management.InvalidAuthenticationException;
import com.insurance.management.Insurance;

public abstract class Account implements Comparable<Account> {

	protected User user;

	protected ArrayList<Insurance> insuranceList;

	private AuthenticationStatus status = AuthenticationStatus.SUCCESS;
	
	
	public Account(User user,ArrayList<Insurance> insuranceList ) {
		this.user=user;
		this.insuranceList=insuranceList;
	}
	
	public User getUser() {
		return user;
	}

	public ArrayList<Insurance> getInsuranceList() {
		return insuranceList;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setInsuranceList(ArrayList<Insurance> insuranceList) {
		this.insuranceList = insuranceList;
	}
	

	public final void showUserInfo(User user) {

		if (user != null) {

			StringBuilder builder = new StringBuilder();
			builder.append("User Info: ");
			builder.append("{");
			builder.append(user.getName());
			builder.append(" , ");
			builder.append(user.getLastName());
			builder.append(" , ");
			builder.append(user.getEmail());
			builder.append(" , ");
			builder.append(user.getPassword());
			builder.append(" , ");
			builder.append(user.getJob());
			builder.append(" , ");
			builder.append(user.getAge());
			builder.append(" , ");
			builder.append(user.getLastSystemLoginDate());
			builder.append(" }");

		} else {
			System.out.println("User List is Empty!");
		}

	}

	public void login(String email, String password) throws InvalidAuthenticationException {

		if (email == user.getEmail() && password == user.getPassword()) {

			status.getCode();

		} else {

			throw new InvalidAuthenticationException("Geçersiz Kullanıcı veya Şifre");
		}

	}

	public static void addInsurance(Account account, Insurance insurance) {
		if (account.getInsuranceList().isEmpty()) {
			List<Insurance> insuranceList = new ArrayList<Insurance>();
			insuranceList.add(insurance);
		} else {
			account.getInsuranceList().add(insurance);
		}

	}

	
	public final void showInsurance(List<Insurance> insuranceList) {

		if (!insuranceList.isEmpty()) {
			for (Insurance insurance : insuranceList) {
				StringBuilder builder = new StringBuilder();
				builder.append("Insurance Info: ");
				builder.append("{");
				builder.append(insurance.getInsuranceName());
				builder.append(" , ");
				builder.append(insurance.getInsurancePrice());
				builder.append(" , ");
				builder.append(insurance.getStartInsuranceDate());
				builder.append(" , ");
				builder.append(insurance.getEndInsuranceDate());
				builder.append(" }");
				System.out.println(builder);
			}
		} else {
			System.out.println("Insurance list is Empyt!");
			
		}

	}
	
	public void showUserAddress(User user) {

		if (user.getAdressList().isEmpty()) {
			System.out.println("Adress Lİst is Empty!");

		} else {
			int index = 1;
			List<Adress> adressList = new ArrayList<>();
			adressList = user.getAdressList();

			for (Adress adress : adressList) {
				System.out.println("\n****Address-" + (index++) + "****");
				System.out.println(adress.toString());
			}
		}
	}

	protected abstract double addProfit(double insurancePrice);

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((insuranceList == null) ? 0 : insuranceList.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (insuranceList == null) {
			if (other.insuranceList != null)
				return false;
		} else if (!insuranceList.equals(other.insuranceList))
			return false;
		if (status != other.status)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	
}
