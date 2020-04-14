package com.account.management;

public enum AuthenticationStatus {

	SUCCESS("200","Giriş başarılı"), 
	FAIL("404","Kullanıcı bulunamadı.");

	private final String code;
	private final String description;

	
	private AuthenticationStatus(String code, String description) {
		this.code = code;
		this.description = description;
	}


	public String getCode() {
		return this.code;
	}

	public String getDescription() {
		return this.description;
	}
}
