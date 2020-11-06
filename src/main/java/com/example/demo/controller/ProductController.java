package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
@CrossOrigin(origins = "http://localhost:3000")
@RestController

@RequestMapping("api/v1/")
public class ProductController {
	
	@Autowired
	private ProductRepository repository;
	
	
	@GetMapping("/products")
	public List<Product> getProducts() {
		return this.repository.findAll();
	}
	
	@PostMapping("/products")
	public Product addProduct(@RequestBody Product product) {
		return repository.save(product);	
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable Long id) throws Exception {
		var product = repository.findById(id).orElseThrow(() -> new Exception("Product does not exist"));
		return ResponseEntity.ok(product);
	}
	
	@PutMapping("/products/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails) throws Exception {
		var product = repository.findById(id).orElseThrow(() -> new Exception("Product does not exist"));
		
		product.setName(productDetails.getName());
		product.setCategory(productDetails.getCategory());
		product.setDescription(productDetails.getDescription());
		
		var updatedProduct = repository.save(product);
		
		return ResponseEntity.ok(updatedProduct);
	}
	
	@DeleteMapping("/products/{id}")
	public ResponseEntity<Long> deleteProduct(@PathVariable Long id) {
		repository.deleteById(id);
		return new ResponseEntity<>(id, HttpStatus.OK);
	}
}
