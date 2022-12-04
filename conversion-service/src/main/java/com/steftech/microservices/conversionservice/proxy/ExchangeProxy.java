package com.steftech.microservices.conversionservice.proxy;

import com.steftech.microservices.conversionservice.models.CurrencyConversion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "exchange-service", url = "localhost:8000")
@FeignClient(name = "exchange-service") // url from service registry
public interface ExchangeProxy {

    @GetMapping("/exchange/from/{from}/to/{to}")
    public CurrencyConversion getExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);
}
