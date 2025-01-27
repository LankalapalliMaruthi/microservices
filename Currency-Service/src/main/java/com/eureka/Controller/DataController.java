package com.eureka.Controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eureka.Entity.CurrencyData;
import com.eureka.Service.DataService;
import com.eureka.entity.CurrencyExchange;
import com.eureka.figen.FeignClientCode;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/api/v1")
public class DataController {
@Autowired
DataService ds;
@Autowired
FeignClientCode feignClientCode;
@GetMapping("/from/{from}/to/{to}/quantity/{quantity}")
@CircuitBreaker(name = "Currency-Service", fallbackMethod  = "CurrencyExchangeFallback")
public ResponseEntity<?> calculateCurrencyConversion(@PathVariable String from,@PathVariable String to,@PathVariable double quantity){
	CurrencyExchange currencyData=feignClientCode.retrieveData(from, to);
	CurrencyData data=ds.calculateCurrencyConversion(from,to,quantity,currencyData.getConversion());
return ResponseEntity.status(HttpStatus.OK)
			.header("value","amountcalculated")
			.body(data);



}

public ResponseEntity<?> currencyExchangeFallback(
        String from, String to, double quantity, Throwable ex) {

    // Log the exception if needed
    System.out.println("Fallback triggered for from = " + from + ", to = " + to + " due to " + ex.getMessage());

    // Provide a default response or a custom fallback response
    CurrencyExchange fallbackResponse = new CurrencyExchange();
    fallbackResponse.setFrom(from);
    fallbackResponse.setTo(to);
    fallbackResponse.setConversion(0.0);  // Default value if the service is down
    
    CurrencyData currencyConversion = new CurrencyData();
    currencyConversion.setFrom(from);
    currencyConversion.setTo(to);
    currencyConversion.setQuantity(quantity);
    currencyConversion.setConversion(fallbackResponse.getConversion());
    currencyConversion.setTotalAmount(quantity * fallbackResponse.getConversion());
    currencyConversion.setLocalDate(LocalDateTime.now());
    
    // You can optionally log or save the failed conversion if needed
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .header("value", "Fallback: currency conversion failed due to service unavailability")
            .body(currencyConversion);
}


}
