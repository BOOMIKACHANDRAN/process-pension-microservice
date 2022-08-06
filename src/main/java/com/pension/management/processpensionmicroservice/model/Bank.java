package com.pension.management.processpensionmicroservice.model;

public class Bank {

	private String bankType;

	public Bank() {
		super();
	}

	public Bank(String bankType) {
		super();
		this.bankType = bankType;
	}

	public String getBankType() {
		return bankType;
	}

	public void setBankType(String bankType) {
		this.bankType = bankType;
	}
}
