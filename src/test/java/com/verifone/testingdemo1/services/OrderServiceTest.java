package com.verifone.testingdemo1.services;

import com.verifone.api.order.model.MerchantOrder;
import com.verifone.api.order.model.MerchantOrderResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @InjectMocks
    OrderService orderService;

    @Mock
    ValidationService validationService;

//    @Test
//    void createOrder() {
//
//        MerchantOrder merchantOrder = new MerchantOrder();
//
//        Mockito.when(validationService.validatePayload(merchantOrder)).thenReturn(true);
//
//        MerchantOrderResponse merchantOrderResponse = orderService.createOrder(merchantOrder);
//
//        Assertions.assertThat(merchantOrderResponse).isNotNull();
//    }


    @Test
    void createOrderValidationFalse() {

        MerchantOrder merchantOrder = new MerchantOrder();

        Mockito.when(validationService.validatePayload(merchantOrder)).thenReturn(false);

        Map<String, String> map = Collections.emptyMap();
        // Mockito.when(validationService.validate(merchantOrder)).thenReturn(Mockito.any());

        Assertions.assertThatThrownBy(() -> orderService.createOrder(merchantOrder)).isInstanceOf(RuntimeException.class);
    }
}