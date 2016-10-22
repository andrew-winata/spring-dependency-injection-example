package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.model.Customer;
import com.example.model.Order;
import com.example.repository.CustomerRepository;
import com.example.webservice.EmailEngineApi;

@Component
public class OrderEmailNotificationService implements OrderNotificationService {

	@Autowired
	private EmailEngineApi emailEngineApi;
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public void sendNotificationToCustomer(Order order) {
		Customer customer = customerRepository.findById(order.getCustomerId());
		emailEngineApi.sendEmail("no-reply@blibli.com", customer.getEmail(), "Hai, " + customer.getName()
				+ ", kami telah menerima pesanan anda.");
	}

}
