package com.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.datasource.DataSourceManager;
import com.example.model.Order;

@Component
public class OrderRepository {
	
	@Autowired
	private DataSourceManager dataSourceManager;
	
	public void create(Order order) {
		dataSourceManager.doConnect();
		System.out.println("Order ID:" + order.getId() + " created.");
	}
}
