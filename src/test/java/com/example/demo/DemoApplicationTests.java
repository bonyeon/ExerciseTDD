package com.example.demo;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void plus(){
        int result = Calculator.plus(1,2);

        assertEquals(3,result);
        assertEquals(5, Calculator.plus(1,4));
    }

}
