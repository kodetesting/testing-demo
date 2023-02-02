package com.verifone.testingdemo1.services;

import com.verifone.api.order.model.*;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Map;

@Service
public class ValidationService {

    boolean validatePayload(MerchantOrder merchantOrder) {
        return true;
    }

    Map<String, String> validate(MerchantOrder merchantOrder) {
       return Collections.singletonMap("k1", "v1");
    }
}
