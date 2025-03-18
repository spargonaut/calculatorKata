package com.interview.calculator;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void shouldProduceZeroWhenGivenAnEmptyString() {
        Calculator calculator = new Calculator();

        int actualResult = calculator.add("");

        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldThrowWhenGivenANonNumericCharacter() {
        Calculator calculator = new Calculator();

        assertThrows(
                NumberFormatException.class,
                () -> calculator.add("a")
        );
    }

    @Test
    public void shouldProduceTheSameIntegerWhenGivenASingleIntegerString() {
        Calculator calculator = new Calculator();

        int actualResult = calculator.add("5");

        int expectedResult = 5;
        assertEquals(expectedResult, actualResult);
    }
}
