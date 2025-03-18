package com.interview.calculator;

public class Calculator {
    public int add(String values) {
        if (values == null || values.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(values);
    }
}
