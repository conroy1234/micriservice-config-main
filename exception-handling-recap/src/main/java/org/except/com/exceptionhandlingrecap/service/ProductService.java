package org.except.com.exceptionhandlingrecap.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.except.com.exceptionhandlingrecap.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductService {

	private static List<Product> products = new ArrayList<>();

	static {
		products.add(new Product(1, "apple", BigDecimal.ONE, 3));
		products.add(new Product(2, "pear", BigDecimal.ONE, 5));
		products.add(new Product(3, "mango", BigDecimal.ONE, 2));
	}

	public Product addProduct(Product product) {
		product.setId(products.size() + 1);
		products.add(product);
		return product;
	}

	public List<Product> findById(int id) {
		return products.stream().filter(prod -> prod.getId() == id).collect(Collectors.toList());	
	}

	public List<Product> findAll() {
		return products;
	}
	
	public void removeById(int id) {
		products.stream().filter(prod ->{
			if(prod.getId() == id) 
				products.remove(prod);
			return true;
			
		}).collect(Collectors.toList());		
		}
	}

