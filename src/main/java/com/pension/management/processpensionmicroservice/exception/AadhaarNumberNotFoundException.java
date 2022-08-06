package com.pension.management.processpensionmicroservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AadhaarNumberNotFoundException extends RuntimeException{

	public AadhaarNumberNotFoundException(String message) {
		super(message);
	}

}
