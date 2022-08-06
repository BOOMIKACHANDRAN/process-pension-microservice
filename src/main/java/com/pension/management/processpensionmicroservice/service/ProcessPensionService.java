package com.pension.management.processpensionmicroservice.service;

import com.pension.management.processpensionmicroservice.model.PensionerDetail;
import com.pension.management.processpensionmicroservice.model.ProcessPension;

public interface ProcessPensionService {

	public PensionerDetail getPensionerDetail(String token, Long aadhaarNumber);
	public ProcessPension calculatePensionAmountAndBankServiceCharge(PensionerDetail pensionerDetail);
}
