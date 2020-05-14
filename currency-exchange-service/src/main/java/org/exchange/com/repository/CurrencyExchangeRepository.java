package org.exchange.com.repository;

import org.exchange.com.model.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Integer> {
 public CurrencyExchange findByFromAndTo(String from,String to);
}
