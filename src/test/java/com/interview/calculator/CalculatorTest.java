package com.interview.calculator;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(Lifecycle.PER_CLASS)
public class CalculatorTest {

    private Calculator calculator;

    @BeforeAll
    public void setup() {
        calculator = new Calculator();
    }

    @Test
    public void shouldCreateACalculatorInstance() {
        assertNotNull(calculator);
    }

    @Test
    public void shouldProduceZeroWhenGivenNull() {
        assertEquals(0, calculator.add(null));
    }

    @Test
    public void shouldProduceZeroWhenGivenAnEmptyString() {
        assertEquals(0, calculator.add(""));
    }

    @Test
    public void shouldThrowWhenGivenANonNumericCharacter() {
        assertThrows(
                NumberFormatException.class,
                () -> calculator.add("a")
        );
    }

    @Test
    public void shouldProduceTheSameIntegerWhenGivenASingleIntegerString() {
        assertEquals(5, calculator.add("5"));
    }

    @Test
    public void shouldAddTwoIntegersWhenSeparatedByAComma() {
        assertEquals(3, calculator.add("1,2"));
    }

    @Test
    public void shouldAddMultipleIntegersWhenSeparatedByAComma() {
        assertEquals(15, calculator.add("1,2,3,4,5"));
    }

    @Test
    public void shouldAddTwoIntegersWhenSeparatedByNewLines() {
        assertEquals(3, calculator.add("1\n2"));
    }

    @Test
    public void shouldAddMultipleIntegersWhenSeparatedByNewLines() {
        assertEquals(6, calculator.add("1\n2\n3"));
    }
}
