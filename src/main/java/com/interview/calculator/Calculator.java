package com.interview.calculator;

public class Calculator {
    public int add(String values) {
        if (values == null || values.isEmpty()) {
            return 0;
        }
        if (values.contains(",")) {
            String[] separateValues = values.split(",");
            int firstValue = Integer.parseInt(separateValues[0]);
            int secondValue = Integer.parseInt(separateValues[1]);
            return firstValue + secondValue;
        }
        return Integer.parseInt(values);
    }
}
