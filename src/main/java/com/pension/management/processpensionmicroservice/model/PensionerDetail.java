package com.pension.management.processpensionmicroservice.model;

public class PensionerDetail {

	private Double salaryEarned;
	
	private Double allowances;
	
	private String pensiontype;
	
	private Bank bankDetail;

	public PensionerDetail() {
		super();
	}

	public PensionerDetail(Double salaryEarned, Double allowances, String pensiontype, Bank bankDetail) {
		super();
		this.salaryEarned = salaryEarned;
		this.allowances = allowances;
		this.pensiontype = pensiontype;
		this.bankDetail = bankDetail;
	}

	public Double getSalaryEarned() {
		return salaryEarned;
	}

	public void setSalaryEarned(Double salaryEarned) {
		this.salaryEarned = salaryEarned;
	}

	public Double getAllowances() {
		return allowances;
	}

	public void setAllowances(Double allowances) {
		this.allowances = allowances;
	}

	public String getPensiontype() {
		return pensiontype;
	}

	public void setPensiontype(String pensiontype) {
		this.pensiontype = pensiontype;
	}

	public Bank getBankDetail() {
		return bankDetail;
	}

	public void setBankDetail(Bank bankDetail) {
		this.bankDetail = bankDetail;
	}

	@Override
	public String toString() {
		return "PensionerDetail [salaryEarned=" + salaryEarned + ", allowances=" + allowances + ", pensiontype="
				+ pensiontype + ", bankDetail=" + bankDetail + "]";
	}
	
}
