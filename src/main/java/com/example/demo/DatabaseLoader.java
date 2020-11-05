package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@Component 
public class DatabaseLoader implements CommandLineRunner { 

	private final ProductRepository repository;

	@Autowired 
	public DatabaseLoader(ProductRepository repository) {
		this.repository = repository;
	}

	@Override
	public void run(String... strings) throws Exception {	
		this.repository.save(new Product("Chocofreddo", "Cold Drink", "Sweet beverage."));
		this.repository.save(new Product("Espresso", "Hot Drink", "Very strong beverage."));
	}
}