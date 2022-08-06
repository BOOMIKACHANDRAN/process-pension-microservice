package com.pension.management.processpensionmicroservice.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pension.management.processpensionmicroservice.exception.TokenExpiredException;
import com.pension.management.processpensionmicroservice.model.PensionerDetail;
import com.pension.management.processpensionmicroservice.model.ProcessPension;
import com.pension.management.processpensionmicroservice.proxy.ProcessPensionProxy;
import com.pension.management.processpensionmicroservice.service.ProcessPensionService;

@Component
public class ProcessPensionServiceImpl implements ProcessPensionService{
	
	private Logger LOGGER = LoggerFactory.getLogger(ProcessPensionServiceImpl.class);
	
	@Autowired 
	private ProcessPensionProxy processPensionProxy;
	
	/*
	 * Method to get Pensioner Detail
	 */
	@Override
	public PensionerDetail getPensionerDetail(String token, Long aadhaarNumber) {
		LOGGER.info("Inside getPensionerDetail");
		try {
			return processPensionProxy.getPensionerDetail(token, aadhaarNumber);
		}
		catch(Exception e){
			LOGGER.info("Token Expired");
			throw new TokenExpiredException("Token Expired");
		}
	}
	
	/*
	 * Method to Calculate Pension Amount and Bank Service Charge
	 */
	@Override
	public ProcessPension calculatePensionAmountAndBankServiceCharge(PensionerDetail pensionerDetail) {
		LOGGER.info("Inside calculatePensionAmountAndBankServiceCharge");
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
