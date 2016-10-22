package com.example.webservice;

import org.springframework.stereotype.Component;

@Component
public class EmailEngineApi {
	public void sendEmail(String senderAddress, String destinationAddress, String message) {
		System.out.println("Send email from: " + senderAddress + ", to :" + destinationAddress + ", with message :" + message);
	}
}
