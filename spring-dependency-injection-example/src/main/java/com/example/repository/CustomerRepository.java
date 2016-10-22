package com.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.datasource.DataSourceManager;
import com.example.model.Customer;

@Component
public class CustomerRepository {
	
	@Autowired
	private DataSourceManager dataSourceManager;
	
	public Customer findById(String customerId) {
		dataSourceManager.doConnect();
		Customer customer = new Customer();
		customer.setId(customerId);
		customer.setName("Budi");
		customer.setAddress("Jl. KS Tubun 2C No.8");
		customer.setEmail("budi@gdn-commerce.com");
		customer.setPhoneNumber("08781239041");
		return customer;
	}
}
