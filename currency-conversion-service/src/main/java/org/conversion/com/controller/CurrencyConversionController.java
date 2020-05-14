package org.conversion.com.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.conversion.com.model.CurrencyConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {

	@Autowired
	Environment environment;

	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion retrieveEnchangeValue(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);

		ResponseEntity<CurrencyConversion> response = new RestTemplate()
				.getForEntity("http://localhost:9000/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class, uriVariables);
		
		CurrencyConversion exchange = response.getBody();		
		
		return new CurrencyConversion(exchange.getId(), from, to, exchange.getConversionMultiple(), quantity, quantity.multiply(exchange.getConversionMultiple()), exchange.getPort());

	}
	
	

}
