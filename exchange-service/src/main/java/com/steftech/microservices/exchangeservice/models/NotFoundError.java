package com.steftech.microservices.exchangeservice.models;

import java.io.Serializable;

public class NotFoundError implements Serializable {

    String message;

    public NotFoundError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
