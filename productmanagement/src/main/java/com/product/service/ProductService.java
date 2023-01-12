package com.product.service;

import com.product.entity.Product;

public interface ProductService {
	Product save(Product p); 
	 void delete(int id);
	 void update(Product p, int id);
	 Product getProductById(int id);
	
}
