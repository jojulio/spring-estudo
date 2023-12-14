package com.example.app.dtos;

import jakarta.validation.constraints.NotNull;

public class RequestProductDto {

    public String id;

    @NotNull
    public String name;

    @NotNull
    public Integer price_in_cents;

    public RequestProductDto(String id, String name, Integer price_in_cents) {
        this.id = id;
        this.name = name;
        this.price_in_cents = price_in_cents;
    }
}
