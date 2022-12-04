package com.steftech.microservices.exchangeservice.controllers;

import com.steftech.microservices.exchangeservice.models.Currency;
import com.steftech.microservices.exchangeservice.services.CurrencyService;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExchangeController {

    private final CurrencyService currencyService;
    private final Environment environment;


    public ExchangeController(CurrencyService currencyService, Environment environment) {
        this.currencyService = currencyService;
        this.environment = environment;
    }

    @GetMapping("/exchange/from/{from}/to/{to}")
    public Currency getExchangeValue(@PathVariable String from, @PathVariable String to){
        //Currency returnCurrency = new Currency(1L, "usd", "euro", BigDecimal.valueOf(2));
        String port = environment.getProperty("local.server.port");
        Currency currency = currencyService.getExchangeValue(from, to);
        currency.setEnvironment(port);
        return currency;

    }
}
