package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
}
