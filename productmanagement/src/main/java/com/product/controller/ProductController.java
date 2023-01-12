package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product.entity.Product;
import com.product.service.ProductService;
import com.product.serviceimpl.ProductServiceImpl;

@RestController
public class ProductController {
	@Autowired
	productServiceImpl productServiceImpl;
	
	@PostMapping("/product")
	String saveProduct(@RequestBody Product product)
	{
		productServiceImpl.save(product);
		return (product.getProductId()+""+product.getProductName()+""+product.getProductPrice());
		
	}
	
	
	@DeleteMapping("/delete/{productId}")
	void deleteProduct(@PathVariable("productId") int id)
	{
		productServiceImpl.deleteProduct(id);
		
	}

	
	@GetMapping("/product/{productId}")
	Product getProductDetails(@PathVariable("productId") int productId) 
	{
		return productServiceImpl.getProductById(productId);
	}


	@PutMapping("/product/{productId}")
	void update(@RequestBody Product product,@PathVariable int productId)
	{
		productServiceImpl.update(product, productId);
	}

}