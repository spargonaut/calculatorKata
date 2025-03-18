package com.interview.calculator;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CalculatorTest {

    @Test
    public void shouldCreateACalculatorInstance() {
        Calculator calculator = new Calculator();
        assertNotNull(calculator);
    }
}
