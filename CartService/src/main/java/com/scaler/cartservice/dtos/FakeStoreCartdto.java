package com.scaler.cartservice.dtos;

import com.scaler.cartservice.models.products;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreCartdto {
    private Long id;
    private Long userId;
    private String date;
    private String product;
}
