package org.exchange.com.controller;

import java.math.BigDecimal;
import java.util.List;

import org.exchange.com.model.CurrencyExchange;
import org.exchange.com.service.CurrencyExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	Environment environment;
	
	@Autowired
	CurrencyExchangeService currencyExchangeService;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange  retrieveEnchangeValue(@PathVariable String from , @PathVariable String to) {
		
		CurrencyExchange exchange= currencyExchangeService.findByFromAndTo(from, to);
		exchange.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return exchange;
		
	}
	
	@GetMapping("/find/all")
	public List<CurrencyExchange> findAll(){
		return currencyExchangeService.findAll();
	}

}
