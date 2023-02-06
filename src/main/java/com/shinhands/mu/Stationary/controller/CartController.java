package com.shinhands.mu.Stationary.controller;

import com.shinhands.mu.Stationary.dto.CartDTO;
import com.shinhands.mu.Stationary.entity.Cart;
import com.shinhands.mu.Stationary.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


@RestController("")
@RequestMapping(value="/cart")
public class CartController {
    @Autowired
    CartService cartService;
    @RequestMapping(value="",method= RequestMethod.GET)
    public ResponseEntity getCart()
    {
        return ResponseEntity.ok().body(cartService.getAllCarts());
    }
    @PostMapping()
    public ResponseEntity<CartDTO> addCart(@RequestBody CartDTO categoryDTO)
    {
        return ResponseEntity.ok().body(cartService.addCart(categoryDTO));
    }
    @GetMapping(value="/{id}")
    public ResponseEntity getCartById(@PathVariable(name="id") long id)
    {
        return ResponseEntity.ok().body(cartService.getCartById(id));
    }
    @PutMapping(value="/{id}")
    public ResponseEntity updateCart(@PathVariable(name="id") long id,@RequestBody CartDTO categoryDTO)
    {
        return ResponseEntity.ok().body(cartService.updateCart(id,categoryDTO));
    }
    @DeleteMapping(value="/{id}")
    public ResponseEntity deleteCart(@PathVariable(name="id") long id,@RequestBody CartDTO categoryDTO)
    {
        return ResponseEntity.ok().body(cartService.updateCart(id,categoryDTO));
    }
}
