package com.in28minutes.springboot.microservice.example.forex;
import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForexController {
  
  @Autowired
  private Environment environment;
  
  @Autowired
  private ExchangeValueRepository repository;
  
  @GetMapping("/currency-exchange/from/{from}/to/{to}")
  public ExchangeValue retrieveExchangeValue
    (@PathVariable String from, @PathVariable String to){
	  
    //BigDecimal value = new BigDecimal(75);
    ExchangeValue exchangeValue = //new ExchangeValue(10001L,from,to,value);
        repository.findByFromAndTo(from, to);
    System.out.println("EXCHANGE VALUE:"+exchangeValue +"for :"+from);
    System.out.println("PORT:"+Integer.parseInt(environment.getProperty("local.server.port")));
    exchangeValue.setPort(
        Integer.parseInt(environment.getProperty("local.server.port")));
    
    
    return exchangeValue;
  }
}