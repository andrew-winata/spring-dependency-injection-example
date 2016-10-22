package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.model.Order;
import com.example.model.OrderItem;
import com.example.model.Product;
import com.example.repository.OrderRepository;
import com.example.repository.ProductRepository;

@Component
public class OrderService {
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	private OrderNotificationService orderNotificationService;
	
	public void setOrderNotificationService(OrderNotificationService orderNotificationService) {
		this.orderNotificationService = orderNotificationService;
	}

	public void createOrder(Order order) throws Exception {
		List<OrderItem> items = order.getItems();
		for (OrderItem item : items) {
			Product savedProduct = productRepository.findById(item.getProductId());
			if (savedProduct.getStock() < item.getQuantity()) {
				throw new Exception("Stock unavailable");
			}
		}
		orderRepository.create(order);
		orderNotificationService.sendNotificationToCustomer(order);
	}
}
