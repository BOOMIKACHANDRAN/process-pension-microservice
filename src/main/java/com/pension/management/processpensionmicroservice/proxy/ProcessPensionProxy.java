package com.pension.management.processpensionmicroservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.pension.management.processpensionmicroservice.model.PensionerDetail;

//@FeignClient(name="pensioner-detail",url="${pensioner-detail.uri}")
@FeignClient(name="pensioner-detail",url="http://localhost:8080")
public interface ProcessPensionProxy {

	@GetMapping("/PensionerDetailByAadhaar/{aadhaarNumber}")
	public PensionerDetail getPensionerDetail(@RequestHeader("Authorization") String token, @PathVariable Long aadhaarNumber);

}
