package com.verifone.testingdemo1.controller;

import com.verifone.api.order.model.MerchantOrder;
import com.verifone.api.order.model.MerchantOrderResponse;
import com.verifone.testingdemo1.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order-service")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/manual-order")
    ResponseEntity<?> craeteOrder(@RequestBody MerchantOrder merchantOrder) {

        MerchantOrderResponse merchantOrderResponse = orderService.createOrder(merchantOrder);
        return new ResponseEntity<>(merchantOrderResponse, HttpStatus.CREATED);

    }
}
