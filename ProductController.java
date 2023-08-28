package com.Prakshan.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Prakshan.demo.Entity.Product;
import com.Prakshan.demo.Service.productService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
public class ProductController {
	
	@Autowired
	private productService ProductSer;
	
	@PostMapping("/saveProduct")
	public ResponseEntity<?> saveProduct(@RequestBody Product product )
	{
		return new ResponseEntity<>(ProductSer.saveProduct(product),HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<?> getAllProduct()
	{
		return new ResponseEntity<>(ProductSer.getAllProduct(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?>getProductById(@PathVariable Integer id)
	{
		return new ResponseEntity<>(ProductSer.getProductById(id),HttpStatus.OK);
	}
	
	@GetMapping("/deleteProduct/{id}")
	public ResponseEntity<?>deleteProduct(@PathVariable Integer id)
	{
		return new ResponseEntity<>(ProductSer.deleteProduct(id),HttpStatus.OK);
	}
	
	@PostMapping("/editProduct/{id}")
	public ResponseEntity<?>editProduct(@RequestBody Product product,@PathVariable Integer id)
	{
		return new ResponseEntity<>(ProductSer.editProduct(product,id),HttpStatus.CREATED);
	} 

}
