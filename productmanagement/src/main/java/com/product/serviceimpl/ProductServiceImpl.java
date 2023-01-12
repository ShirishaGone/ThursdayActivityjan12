package com.product.serviceimpl;

import java.util.List;
import java.util.function.IntBinaryOperator;

import org.springframework.beans.factory.annotation.Autowired;

import com.product.entity.Product;
import com.product.repository.ProductRepository;
import com.product.service.ProductService;


public abstract class ProductServiceImpl implements ProductService {
	@Autowired
	ProductRepository productRepository;
	
	@Override
	public Product save(Product p)
	{
		return productRepository.save(p);
	}

	//Delete the product
	@Override
	public void deleteProduct(int id)
	{
		productRepository.deleteById(id);
	}

	
	//Update the product
	@Override
	public void update(Product params, int productId)
	{
		Product p=productRepository.findById(productId).get();
		p.setProductName(params.getProductName());
		p.setProductPrice(params.getProductPrice());
		
		productRepository.save(p);
		
	}
	
	//Get all product Details
	@Override
	public Product getProductById(int Id) {
		return productRepository.findById(Id).get();
	}


}
