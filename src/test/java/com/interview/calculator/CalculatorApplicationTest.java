package com.interview.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static com.interview.calculator.Constants.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class CalculatorApplicationTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @InjectMocks
    CalculatorApplication app;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void runShouldSumReturn0WhenNoNumbers() {
        app.run();
        assertEquals(THE_RESULT_FOR_THE_SUM_IS + 0, outputStreamCaptor.toString().trim());
    }

    @Test
    void runShouldSum1Numbers() {
        app.run("2");
        assertEquals(THE_RESULT_FOR_THE_SUM_IS + 2, outputStreamCaptor.toString().trim());
    }

    @Test
    void runShouldSum2Numbers() {
        app.run("2,3");
        assertEquals(THE_RESULT_FOR_THE_SUM_IS + 5, outputStreamCaptor.toString().trim());
    }

    @Test
    void runShouldSum5Numbers() {
        app.run("1,2,3,4,5");
        assertEquals(THE_RESULT_FOR_THE_SUM_IS + 15, outputStreamCaptor.toString().trim());
    }

    @Test
    void runShouldSumNumbersWhenContainsNewLine() {
        app.run("1\\n2,3");
        assertEquals(THE_RESULT_FOR_THE_SUM_IS + 6, outputStreamCaptor.toString().trim());
    }

    @Test
    void runShouldSumNumbersWhenContainsNewLineAndSlashes() {
        app.run("//;\\n1;2");
        assertEquals(THE_RESULT_FOR_THE_SUM_IS + 3, outputStreamCaptor.toString().trim());
    }

    @Test
    void runShouldReturnMessageWhenContainsNegativeNumbers() {
        app.run("2,-4,3,-5");
        assertEquals(NEGATIVES_NOT_ALLOWED + "[-4, -5]", outputStreamCaptor.toString().trim());
    }

    @Test
    void runShouldSumNumbersIgnoringGreaterThan1000() {
        app.run("1,2,3,1001,4");
        assertEquals(THE_RESULT_FOR_THE_SUM_IS + 10, outputStreamCaptor.toString().trim());
    }

    @Test
    void runShouldSumNumbersWithDelimiterAnyLength() {
        app.run("//[|||]\\n1|||2|||3");
        assertEquals(THE_RESULT_FOR_THE_SUM_IS + 6, outputStreamCaptor.toString().trim());
    }

    @Test
    void runShouldSumNumbersWithMultiDelimiter() {
        app.run("//[|][%]\\n1|2%3");
        assertEquals(THE_RESULT_FOR_THE_SUM_IS + 6, outputStreamCaptor.toString().trim());
    }

    @Test
    void runShouldSumNumbersWithMultiDelimiterAnyLength() {
        app.run("//[|][%]\\n1|||||2%%%3");
        assertEquals(THE_RESULT_FOR_THE_SUM_IS + 6, outputStreamCaptor.toString().trim());
    }

    @Test
    void runShouldReturnErrorMessageWhenArgumentContainsNoNumber() {
        app.run("2,3,t");
        assertEquals(AT_LEAST_ONE_VALUE_CAN_T_BE_CONVERTED_TO_A_NUMBER, outputStreamCaptor.toString().trim());
    }
    @Test
    void runShouldReturnErrorMessageWhenNoNumber() {
        app.run("t");
        assertEquals(AT_LEAST_ONE_VALUE_CAN_T_BE_CONVERTED_TO_A_NUMBER, outputStreamCaptor.toString().trim());
    }

    @Test
    void runShouldReturn0WhenEmptyString() {
        app.run("");
        assertEquals(THE_RESULT_FOR_THE_SUM_IS + 0, outputStreamCaptor.toString().trim());
    }
}