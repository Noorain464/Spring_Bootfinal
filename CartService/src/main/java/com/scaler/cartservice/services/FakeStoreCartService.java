package com.scaler.cartservice.services;

import com.scaler.cartservice.dtos.FakeStoreCartdto;
import com.scaler.cartservice.models.Cart;
import com.scaler.cartservice.models.products;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class FakeStoreCartService implements CartService {
    private RestTemplate restTemplate = new RestTemplate();
    @Override
    public List<Cart> getAllCarts() {
        FakeStoreCartdto[] fakeStoreCartdto = restTemplate.getForObject("https://fakestoreapi.com/carts/", FakeStoreCartdto[].class);
        return fakeCartstoCarts(Arrays.asList(fakeStoreCartdto));
    }

    @Override
    public Cart getSingleCart(Long id) {
        FakeStoreCartdto fakeStoreCartdto = restTemplate.getForObject("https://fakestoreapi.com/carts/" + id, FakeStoreCartdto.class);
        return fakeCartToCart(fakeStoreCartdto);
    }

    @Override
    public String deleteCart(Long id) {
        getAllCarts().removeIf(fakeStoreCartdto -> fakeStoreCartdto.getId().equals(id));
        return "deleted";
    }

    @Override
    public Cart createProduct(Cart cart) {
        return new Cart();
    }

    @Override
    public Cart getUserCart(Long id) {
        FakeStoreCartdto fakeStoreCartdto = restTemplate.getForObject("https://fakestoreapi.com/carts/user" + id, FakeStoreCartdto.class);
        return fakeCartToCart(fakeStoreCartdto);
    }

    private List<Cart> fakeCartstoCarts(List<FakeStoreCartdto> fakeStoreCartdtos) {
        List<Cart> carts = new ArrayList<>();
        for (FakeStoreCartdto fakeStoreCartdto: fakeStoreCartdtos) {
            carts.add(fakeCartToCart(fakeStoreCartdto));
        }
        return carts;
    }


    private Cart fakeCartToCart(FakeStoreCartdto fakeStoreCartdto) {
        Cart c = new Cart();
        c.setId(fakeStoreCartdto.getId());
        c.setProduct(new products(fakeStoreCartdto.getProduct(), fakeStoreCartdto.getProduct()));
        c.setUserId(fakeStoreCartdto.getUserId());
        c.setDate(fakeStoreCartdto.getDate());
        return c;
    }
}
