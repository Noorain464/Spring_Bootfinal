package com.scaler.cartservice.controller;

import com.scaler.cartservice.models.Cart;
import com.scaler.cartservice.services.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {
    CartService cs ;
    public CartController(CartService cs){
        this.cs = cs;
    }
    @GetMapping("/carts")
    public List<Cart> getAllCarts(){

        return cs.getAllCarts();
    }

    @GetMapping("/carts/{id}")
    public Cart getsinglecart(@PathVariable("id") Long id ){
        return cs.getSingleCart(id);
    }
//    @DeleteMapping(value="/carts/{id}")
//    public String deleteCart(@PathVariable("id") Long id){
//        return cs.deleteCart(id);
//    }
    @PostMapping("/new_cart")
    public Cart createCart(@RequestBody Cart cart){
        return cs.createProduct(cart);
    }
    @GetMapping("carts/user/{id}")
    public Cart getuserCart(@PathVariable("id") Long id){
        return cs.getUserCart(id);
    }

}
