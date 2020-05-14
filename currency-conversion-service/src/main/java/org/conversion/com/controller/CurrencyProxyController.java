package org.conversion.com.controller;

import java.math.BigDecimal;

import org.conversion.com.model.CurrencyConversion;
import org.conversion.com.proxy.CurrencyConvertionProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proxy")
public class CurrencyProxyController {
	

	@Autowired
	CurrencyConvertionProxy proxi ;

	@GetMapping("/convert/proxi/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion retrieveEnchangeValue(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {	
		 
		CurrencyConversion exchange = proxi.getConversionValue(from, to);

		return new CurrencyConversion(exchange.getId(), from, to, exchange.getConversionMultiple(), quantity,
				quantity.multiply(exchange.getConversionMultiple()), exchange.getPort());

	}
	

}
