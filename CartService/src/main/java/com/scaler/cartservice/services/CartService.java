package com.scaler.cartservice.services;

import com.scaler.cartservice.models.Cart;

import java.util.List;

public interface CartService {
    List<Cart> getAllCarts();

    Cart getSingleCart(Long id);
    String deleteCart(Long id);
    Cart createProduct(Cart cart);
    Cart getUserCart(Long id);
}
