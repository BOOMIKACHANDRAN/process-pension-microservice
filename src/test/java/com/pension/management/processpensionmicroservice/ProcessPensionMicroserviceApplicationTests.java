package com.pension.management.processpensionmicroservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pension.management.processpensionmicroservice.model.Bank;
import com.pension.management.processpensionmicroservice.model.PensionerDetail;
import com.pension.management.processpensionmicroservice.model.ProcessPension;
import com.pension.management.processpensionmicroservice.service.ProcessPensionService;

@SpringBootTest
class ProcessPensionMicroserviceApplicationTests {

	@Autowired
	private ProcessPensionService processPensionService;
	
	/*@Test
	void contextLoads() {
	}*/
	
	@Test
	public void testBankServiceChargeForPrivate() {
		PensionerDetail pensionerDetail = new PensionerDetail(45000.0,2000.0,"family",new Bank("private"));
		ProcessPension processPension = processPensionService.calculatePensionAmountAndBankServiceCharge(pensionerDetail);
		assertEquals(550.0,processPension.getBankServiceCharge());
	}
	
	@Test
	public void testBankServiceChargeForPublic() {
		PensionerDetail pensionerDetail = new PensionerDetail(45000.0,2000.0,"family",new Bank("public"));
		ProcessPension processPension = processPensionService.calculatePensionAmountAndBankServiceCharge(pensionerDetail);
		assertEquals(500.0,processPension.getBankServiceCharge());
	}
	
	@Test
	public void testPensionAmount() {
		PensionerDetail pensionerDetail = new PensionerDetail(45000.0,2000.0,"family",new Bank("public"));
		ProcessPension processPension = processPensionService.calculatePensionAmountAndBankServiceCharge(pensionerDetail);
		System.out.println(processPension.getPensionAmount());
		assertEquals(24500.0,processPension.getPensionAmount());
	}

}
