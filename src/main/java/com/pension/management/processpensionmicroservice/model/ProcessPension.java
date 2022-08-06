package com.pension.management.processpensionmicroservice.model;

public class ProcessPension {
	
	private Double pensionAmount;
	
	private Double bankServiceCharge;

	public ProcessPension() {
		super();
	}

	public ProcessPension(Double pensionAmount, Double bankServiceCharge) {
		super();
		this.pensionAmount = pensionAmount;
		this.bankServiceCharge = bankServiceCharge;
	}

	public Double getPensionAmount() {
		return pensionAmount;
	}

	public void setPensionAmount(Double pensionAmount) {
		this.pensionAmount = pensionAmount;
	}

	public Double getBankServiceCharge() {
		return bankServiceCharge;
	}

	public void setBankServiceCharge(Double bankServiceCharge) {
		this.bankServiceCharge = bankServiceCharge;
	}

	@Override
	public String toString() {
		return "ProcessPension [pensionAmount=" + pensionAmount + ", bankServiceCharge=" + bankServiceCharge + "]";
	}

}
