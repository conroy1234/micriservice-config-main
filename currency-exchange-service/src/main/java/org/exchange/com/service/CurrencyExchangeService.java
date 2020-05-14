package org.exchange.com.service;

import java.util.List;

import org.exchange.com.model.CurrencyExchange;
import org.exchange.com.repository.CurrencyExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyExchangeService {

	@Autowired
	CurrencyExchangeRepository currencyExchangeRepository;
	
	public List<CurrencyExchange> findAll(){
		return currencyExchangeRepository.findAll();
		
	}
	
	public CurrencyExchange findByFromAndTo(String from , String to) {
		return currencyExchangeRepository.findByFromAndTo(from, to);
		
	}
}
