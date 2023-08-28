package com.Prakshan.demo.Service;

import java.util.List;

import com.Prakshan.demo.Entity.Product;

public interface productService {
	
	public Product saveProduct(Product product);
	
	public List<Product> getAllProduct();
	
	public Product getProductById(Integer id);
	
	public String deleteProduct(Integer id);
	
	public Product editProduct(Product product,Integer id);
	

}
