package com.Prakshan.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Prakshan.demo.Entity.Product;
import com.Prakshan.demo.Repository.productRepository;

@Service
public class productImpl implements productService{
	
	@Autowired
	private productRepository productRepo;

	@Override
	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub
		return  productRepo.save(product);
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return  productRepo.findAll();
	}

	@Override
	public Product getProductById(Integer id) {
		// TODO Auto-generated method stub;
		return  productRepo.findById(id).get();
	}

	@Override
	public String deleteProduct(Integer id) {
		// TODO Auto-generated method stub
		
		 Product product=productRepo.findById(id).get();
		 
		 if(product!=null)
		 {
			 productRepo.delete(product);
			 return " product deleted sucessfully!!";
		 }
		return "something wrong on server";
	}

	@Override
	public Product editProduct(Product p, Integer id) {
		// TODO Auto-generated method stub
		Product oldproduct=productRepo.findById(id).get();
		oldproduct.setProductName(p.getProductName());
		oldproduct.setDescription(p.getDescription());
		oldproduct.setStatus(p.getStatus());
		oldproduct.setPrice(p.getPrice());
		
		return productRepo.save(oldproduct);
	}

	
	

}
