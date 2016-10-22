package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.datasource.DataSourceManager;
import com.example.model.Order;
import com.example.model.OrderItem;
import com.example.repository.CustomerRepository;
import com.example.repository.OrderRepository;
import com.example.repository.ProductRepository;
import com.example.service.OrderEmailNotificationService;
import com.example.service.OrderService;
import com.example.service.OrderSmsNotificationService;
import com.example.webservice.EmailEngineApi;
import com.example.webservice.SmsEngineApi;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("spring-configuration.xml");

			OrderService orderService = (OrderService) context.getBean("orderService");
			OrderEmailNotificationService orderEmailNotificationService = (OrderEmailNotificationService) context
					.getBean("orderEmailNotificationService");
			OrderSmsNotificationService orderSmsNotificationService = (OrderSmsNotificationService) context
					.getBean("orderSmsNotificationService");

			// Create order and send notification by email
			orderService.setOrderNotificationService(orderEmailNotificationService);
			Order order1 = createOrderData();
			orderService.createOrder(order1);

			// Create order and send notification by sms
			orderService.setOrderNotificationService(orderSmsNotificationService);
			Order order2 = createOrderData();
			orderService.createOrder(order2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static Order createOrderData() {
		Order order = new Order();
		order.setId(UUID.randomUUID().toString());
		order.setCustomerId(UUID.randomUUID().toString());
		List<OrderItem> orderItems = createOrderItemsData();
		order.setItems(orderItems);
		return order;
	}

	public static List<OrderItem> createOrderItemsData() {
		List<OrderItem> items = new ArrayList<>();
		OrderItem item1 = new OrderItem();
		item1.setId(UUID.randomUUID().toString());
		item1.setProductId(UUID.randomUUID().toString());
		item1.setQuantity(10);
		items.add(item1);
		return items;

	}
}
