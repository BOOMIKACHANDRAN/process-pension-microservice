package com.pension.management.processpensionmicroservice.serviceImpl;

import org.springframework.stereotype.Component;

import com.pension.management.processpensionmicroservice.model.PensionerDetail;
import com.pension.management.processpensionmicroservice.model.ProcessPension;
import com.pension.management.processpensionmicroservice.service.ProcessPensionService;

@Component
public class ProcessPensionServiceImpl implements ProcessPensionService{

	@Override
	public ProcessPension calculatePensionAmountAndBankServiceCharge(PensionerDetail pensionerDetail) {
		ProcessPension processPension = new ProcessPension();
		Double pensionAmount = null;
		String bankType = pensionerDetail.getBankDetail().getBankType();
		if(bankType.equalsIgnoreCase("public")) {
			processPension.setBankServiceCharge(500.0);
		}
		else if(bankType.equalsIgnoreCase("private")) {
			processPension.setBankServiceCharge(550.0);
		}
		
		if(pensionerDetail.getPensiontype().equalsIgnoreCase("self")) {
			pensionAmount = (0.8 * pensionerDetail.getSalaryEarned()) + pensionerDetail.getAllowances();
		}
		else if(pensionerDetail.getPensiontype().equalsIgnoreCase("family")) {
			pensionAmount = (0.5 * pensionerDetail.getSalaryEarned()) + pensionerDetail.getAllowances();
		}
		processPension.setPensionAmount(pensionAmount);
		
		return processPension;
	}
	
}
