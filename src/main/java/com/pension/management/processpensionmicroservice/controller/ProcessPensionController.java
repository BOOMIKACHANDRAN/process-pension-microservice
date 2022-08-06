package com.pension.management.processpensionmicroservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.pension.management.processpensionmicroservice.exception.AadhaarNumberNotFoundException;
import com.pension.management.processpensionmicroservice.model.PensionerDetail;
import com.pension.management.processpensionmicroservice.model.ProcessPension;
import com.pension.management.processpensionmicroservice.service.ProcessPensionService;

@RestController
public class ProcessPensionController {

	private Logger LOGGER = LoggerFactory.getLogger(ProcessPensionController.class);

	@Autowired
	ProcessPensionService processPensionService;

	@PostMapping("/ProcessPension/{aadhaarNumber}")
	public ProcessPension processPension(@RequestHeader("Authorization") String token,
			@PathVariable Long aadhaarNumber) {
		LOGGER.info("Inside Process Pension Controller");

		PensionerDetail pensionerDetail = processPensionService.getPensionerDetail(token, aadhaarNumber);
		if(pensionerDetail!=null) {
			LOGGER.info("Inside Process Pension Controller - Got pensioner detail with Aaadhaar Number : " + aadhaarNumber);

			ProcessPension processPension = processPensionService
					.calculatePensionAmountAndBankServiceCharge(pensionerDetail);
			LOGGER.info("Inside Process Pension Controller - Calculated Pension Amount and Bank Service Charge");

			return processPension;
		}
		else {
			LOGGER.info("Pensioner Detail Not found with Aadhaar Number : "+aadhaarNumber);
			throw new AadhaarNumberNotFoundException("Pensioner Detail Not found with Aadhaar Number");
		}
	}
}
