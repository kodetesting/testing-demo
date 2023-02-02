package com.verifone.testingdemo1.services;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class HellloV2Test {

    @InjectMocks
    Helllo hello;



    @Test
    void test1() {
        String actualOutput = hello.sayHello();
        Assertions.assertThat(actualOutput).isNotNull().isNotEmpty().isEqualTo("Hello");
    }



    @Test
    void sayHelloToUser() {
        String actualOutput = hello.sayHelloToUser("Pavan");
        Assertions.assertThat(actualOutput).isEqualTo("Hello Pavan");
    }
}