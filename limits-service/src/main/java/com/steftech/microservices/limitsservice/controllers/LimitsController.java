package com.steftech.microservices.limitsservice.controllers;

import com.steftech.microservices.limitsservice.configuaration.LimitConfig;
import com.steftech.microservices.limitsservice.models.Limit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class LimitsController {

    @Autowired
    private LimitConfig limitConfig;


    @GetMapping("/limits")
    public Limit getLimits(){
        return new Limit(limitConfig.getMinimum(), limitConfig.getMaximum());

    }
}
