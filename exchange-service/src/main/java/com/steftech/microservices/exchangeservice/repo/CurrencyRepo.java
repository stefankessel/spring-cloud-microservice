package com.steftech.microservices.exchangeservice.repo;

import com.steftech.microservices.exchangeservice.models.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CurrencyRepo extends JpaRepository<Currency, Long> {

    public Optional<Currency> findByFromAndTo(String from, String to);
}
