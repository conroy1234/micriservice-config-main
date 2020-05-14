package org.conversion.com.proxy;

import org.conversion.com.model.CurrencyConversion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-exchange-service", url="http://localhost:9000")
public interface CurrencyConvertionProxy {

	@GetMapping("/currency-exchange/from/{from}/to/{to}")	
	public CurrencyConversion getConversionValue(@PathVariable String from, @PathVariable String to) ;

}