package com.steftech.microservices.conversionservice.controllers;


import com.steftech.microservices.conversionservice.proxy.ExchangeProxy;
import com.steftech.microservices.conversionservice.models.CurrencyConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;

@RestController
public class ConversionController {

    @Autowired
    private ExchangeProxy exchangeProxy;



    @GetMapping("/conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion getCurrencyConversion(
            @PathVariable String from,
            @PathVariable String to,
            @PathVariable BigDecimal quantity
            ){
        final String uri = "http://localhost:8000//exchange/from/{from}/to/{to}";
        HashMap<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);
        ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity(uri, CurrencyConversion.class, uriVariables );
        final CurrencyConversion responseBody = responseEntity.getBody();
        return new CurrencyConversion(
                responseBody.getId(),
                from,
                to,
                responseBody.getConversionMultiple(),
                quantity.multiply(responseBody.getConversionMultiple()),
                responseBody.getEnvironment()
        );
    }
    @GetMapping("/conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion getCurrencyConversionFeign(
            @PathVariable String from,
            @PathVariable String to,
            @PathVariable BigDecimal quantity
    ){

        final CurrencyConversion responseBody = exchangeProxy.getExchangeValue(from,to);
        return new CurrencyConversion(
                responseBody.getId(),
                from,
                to,
                responseBody.getConversionMultiple(),
                quantity.multiply(responseBody.getConversionMultiple()),
                responseBody.getEnvironment() + " feign"
        );
    }


}
