package com.pension.management.processpensionmicroservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.pension.management.processpensionmicroservice.controller.ProcessPensionController;
import com.pension.management.processpensionmicroservice.model.Bank;
import com.pension.management.processpensionmicroservice.model.PensionerDetail;
import com.pension.management.processpensionmicroservice.model.ProcessPension;
import com.pension.management.processpensionmicroservice.service.ProcessPensionService;

@AutoConfigureMockMvc
@SpringBootTest
public class ProcessPensionControllerTests {

	@Mock
	ProcessPensionService processPensionService;

	@InjectMocks
	ProcessPensionController processPensionController;

	@Autowired
	MockMvc mockMvc;

	@BeforeEach
	void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(processPensionController).build();
	}

	@Test
	void processPensionTest() throws Exception {

		String token = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJCb29taWthIiwiZXhwIjoxNjYwOTAyMjE5LCJpYXQiOjE2NjA5MDA0MTl9.SNGHWNLeCRxwPvT6fjIT2r6Foc9ovRUdbmfp6oxxqCE";

		PensionerDetail pensioner = new PensionerDetail(15000.0, 10000.0, "family", new Bank("private"));

		Mockito.when(processPensionService.getPensionerDetail(token, 123456789012L)).thenReturn(pensioner);
		Mockito.when(processPensionService.calculatePensionAmountAndBankServiceCharge(pensioner))
				.thenReturn(new ProcessPension(1450.0, 550.0));

		this.mockMvc
				.perform(MockMvcRequestBuilders.post("/ProcessPension/{aadhaarNumber}", 123456789012L)
						.header("Authorization", token))
				.andExpect(MockMvcResultMatchers.status().is2xxSuccessful()).andDo(MockMvcResultHandlers.print());
	}
}
