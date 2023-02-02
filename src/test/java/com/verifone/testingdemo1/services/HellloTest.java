package com.verifone.testingdemo1.services;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HellloTest {

    @Test
    void test1() {

        Helllo hello = new Helllo();
        String actualOutput = hello.sayHello();

        Assertions.assertThat(actualOutput).isNotNull().isNotEmpty().isEqualTo("Hello");

    }



    @Test
    void sayHelloToUser() {
        Helllo hello = new Helllo();
        String actualOutput = hello.sayHelloToUser("Pavan");
        Assertions.assertThat(actualOutput).isEqualTo("Hello Pavan");
    }
}