package org.except.com.exceptionhandlingrecap.controller;

import java.time.LocalDate;

import org.except.com.exceptionhandlingrecap.exception.ProductNotFoundException;
import org.except.com.exceptionhandlingrecap.model.ProductExceptionEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class ProductResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	public ResponseEntity<ProductExceptionEntity> handleProductNotFoundException(ProductNotFoundException message, WebRequest request){
		ProductExceptionEntity productExceptionEntity = new ProductExceptionEntity(message.getMessage(),message.getLocalizedMessage(),LocalDate.now(),request.getDescription(true));
		return new ResponseEntity<ProductExceptionEntity>(productExceptionEntity,HttpStatus.NOT_FOUND);
	}
}
