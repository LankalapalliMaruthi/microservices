package com.eureka.figen;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.eureka.entity.CurrencyExchange;

@FeignClient(name="Exchange-Service")
public interface FeignClientCode {
	@GetMapping("/api/v1/from/{from}/to/{to}")
	CurrencyExchange retrieveData(@PathVariable("from") String from,@PathVariable("to") String to);

}
