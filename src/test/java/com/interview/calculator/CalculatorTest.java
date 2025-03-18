package com.interview.calculator;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CalculatorTest {

    @Test
    public void shouldCreateACalculatorInstance() {
        Calculator calculator = new Calculator();
        assertNotNull(calculator);
    }

    @Test
    public void shouldProduceZeroWhenGivenNull() {
        Calculator calculator = new Calculator();

        int actualResult = calculator.add(null);

        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }
}
