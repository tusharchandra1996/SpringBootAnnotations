package com.boot.work.bootwork.services;

import org.springframework.stereotype.Component;

@Component("cart1")
public class CartServiceImpl1 implements  CartService{
    @Override
    public void addToCart() {
        System.out.println("Adding to cart by cart service 1");
    }
}
