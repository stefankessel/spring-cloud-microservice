package com.steftech.microservices.exchangeservice.services;

import com.steftech.microservices.exchangeservice.exceptions.NotFoundException;
import com.steftech.microservices.exchangeservice.models.Currency;
import com.steftech.microservices.exchangeservice.repo.CurrencyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyService {

    @Autowired
    private CurrencyRepo currencyRepo;


    public Currency getExchangeValue(String from, String to){
        return currencyRepo.findByFromAndTo(from, to).orElseThrow(() -> new NotFoundException("currency not found"));
    }
}
