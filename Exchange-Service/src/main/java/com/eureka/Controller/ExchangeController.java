package com.eureka.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.eureka.Repository.ExchangeRepository;
import com.eureka.entity.CurrencyExchange;

@RestController
@RequestMapping("/api/v1")
public class ExchangeController {
	@Autowired
	ExchangeRepository er;
	@GetMapping("/from/{from}/to/{to}")
	public ResponseEntity<?>currencyConversion(@PathVariable String from,@PathVariable String to){
		Optional<CurrencyExchange>data=er.findByFromAndTo(from,to);
		if(data.isPresent()) {
			CurrencyExchange exchange=data.get();
			return ResponseEntity.status(HttpStatus.OK)
					.header("status", "data saved and retrievd")
					.body(exchange);
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.header("status", " NO data saved and retrievd")
					.body("no data");
		}
	}

}
