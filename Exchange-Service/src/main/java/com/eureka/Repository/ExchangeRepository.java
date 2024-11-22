 package com.eureka.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eureka.entity.CurrencyExchange;

public interface ExchangeRepository  extends JpaRepository<CurrencyExchange, Long>{

	
	Optional<CurrencyExchange> findByFromAndTo(String from, String to);

}
