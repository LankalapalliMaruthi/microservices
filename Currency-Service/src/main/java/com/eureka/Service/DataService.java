package com.eureka.Service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eureka.Entity.CurrencyData;
import com.eureka.Repository.DataRepo;

@Service

public class DataService {
@Autowired 
DataRepo dr;

public  CurrencyData calculateCurrencyConversion(String from, String to, double quantity,double  conversionMultiple){


double totalCalculateAmount = quantity * conversionMultiple;

CurrencyData currencyConversion = new CurrencyData();
currencyConversion.setFrom(from);
currencyConversion.setTo(to);
currencyConversion.setQuantity(quantity);
currencyConversion.setConversion(conversionMultiple);
currencyConversion.setTotalAmount(totalCalculateAmount);
currencyConversion.setLocalDate(LocalDateTime.now());

dr.save(currencyConversion);

return currencyConversion;
}

}
