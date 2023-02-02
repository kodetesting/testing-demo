package com.verifone.testingdemo1.services;

import com.verifone.api.order.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    ValidationService validationService;


    public MerchantOrderResponse createOrder(MerchantOrder merchantOrder) {

        boolean isValid = validationService.validatePayload(merchantOrder);
        if(!isValid) {
            throw new RuntimeException("Validation Error");
        }

        MerchantOrderResponse merchantOrderResponse= new MerchantOrderResponse();
        UUID orderiD = UUID.randomUUID();

        merchantOrderResponse.setOrderId(orderiD);

        return merchantOrderResponse;
    }

}
