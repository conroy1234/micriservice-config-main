package org.except.com.exceptionhandlingrecap.controller;

import java.awt.PageAttributes.MediaType;
import java.net.URI;
import java.util.List;

import org.except.com.exceptionhandlingrecap.exception.ProductNotFoundException;
import org.except.com.exceptionhandlingrecap.model.Product;
import org.except.com.exceptionhandlingrecap.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping("/exception-handling-practice")
	public List<Product> findAll() {
		return productService.findAll();

	}
	
	@PostMapping("/exception-handling-practice")
	@Procedure("application/json") 	
	public ResponseEntity<String> saveProduct(@RequestBody Product product) {
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.buildAndExpand(product.getId()).toUri();
		 product= productService.addProduct(product);
		return new ResponseEntity<String>(location+"/"+product.getId(),HttpStatus.CREATED);
	}
	
	@GetMapping("/exception-handling-practice/{id}")
	public List<Product> findById(@PathVariable int id) {
		List<Product> products = productService.findById(id);
		if(products.isEmpty()) {
			throw new ProductNotFoundException("product not found "+id);
		}
		return products;
	}
	
	@DeleteMapping("/exception-handling-practice/{id}")
	public void removeById(@PathVariable int id) {		
		 productService.removeById(id);
	}

}
