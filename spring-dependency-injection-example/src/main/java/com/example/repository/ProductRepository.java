package com.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.datasource.DataSourceManager;
import com.example.model.Product;

@Component
public class ProductRepository {
	
	@Autowired
	private DataSourceManager dataSourceManager;
	
	public Product findById(String productId) {
		dataSourceManager.doConnect();
		Product product = new Product();
		product.setId(productId);
		product.setStock(100);
		product.setMinimumStock(1);
		return product;
	}
}
