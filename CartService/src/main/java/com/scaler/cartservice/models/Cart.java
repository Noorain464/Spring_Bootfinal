package com.scaler.cartservice.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cart {
    private Long id;
    private Long userId;
    private String date;
    private products product;
}
