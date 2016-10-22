package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.model.Customer;
import com.example.model.Order;
import com.example.repository.CustomerRepository;
import com.example.webservice.SmsEngineApi;

@Component
public class OrderSmsNotificationService implements OrderNotificationService {

	@Autowired
	private SmsEngineApi smsEngineApi;
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public void sendNotificationToCustomer(Order order) {
		Customer customer = customerRepository.findById(order.getCustomerId());
		smsEngineApi.sendSms(customer.getPhoneNumber(),
				"Hai, " + customer.getName()
				+ ", kami telah menerima pesanan anda.");

	}

}
