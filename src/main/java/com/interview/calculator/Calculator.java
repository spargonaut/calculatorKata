package com.interview.calculator;

import java.util.Arrays;

public class Calculator {
    public int add(String values) {
        if (values == null || values.isEmpty()) {
            return 0;
        }
        if (values.contains(",")) {
            String[] separateValues = values.split(",");
            return Arrays.stream(separateValues)
                    .mapToInt(Integer::parseInt)
                    .sum();
        }
        return Integer.parseInt(values);
    }
}
