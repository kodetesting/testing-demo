package com.verifone.testingdemo1.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.verifone.api.order.model.MerchantOrder;
import com.verifone.api.order.model.MerchantOrderResponse;
import com.verifone.testingdemo1.services.OrderService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(OrderController.class)
class OrderControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    OrderService orderService;

    ObjectMapper objectMapper;

    @BeforeEach
    void setup() {
        objectMapper = new ObjectMapper();
    }

    @Test
    void craeteOrder() throws Exception {
        MerchantOrder merchantOrder = new MerchantOrder();

        MerchantOrderResponse merchantOrderResponse = new MerchantOrderResponse();
        UUID orderid = UUID.randomUUID();
        merchantOrderResponse.setOrderId(orderid);

        Mockito.when(orderService.createOrder(merchantOrder)).thenReturn(merchantOrderResponse);

        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/order-service/manual-order")
                        .content(objectMapper.writeValueAsString(merchantOrder))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.orderId", Matchers.is(orderid + "")))
                // .andExpect(MockMvcResultMatchers.jsonPath("$.orderId", Matchers.conta(orderid + "")))
        ;

    }
}