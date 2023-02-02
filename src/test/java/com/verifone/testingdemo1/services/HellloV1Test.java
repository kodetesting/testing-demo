package com.verifone.testingdemo1.services;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HellloV1Test {
    Helllo hello;

    @BeforeEach
    void setUp() {
        hello = new Helllo();
    }


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