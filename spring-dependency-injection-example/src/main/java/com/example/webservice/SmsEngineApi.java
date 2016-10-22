package com.example.webservice;

import org.springframework.stereotype.Component;

@Component
public class SmsEngineApi {
	public void sendSms(String phoneNumber, String message) {
		System.out.println("Send sms to :" + phoneNumber + ", with message :" + message);
	}
}
