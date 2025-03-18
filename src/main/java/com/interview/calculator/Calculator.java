package com.interview.calculator;

import java.util.Arrays;

public class Calculator {
    public int add(String values) {
        if (values == null || values.isEmpty()) {
            return 0;
        }

        String delimiter = parseDelimiter(values);
        if (!delimiter.isEmpty()) {
            String[] separateValues = values.split(delimiter);
            return Arrays.stream(separateValues)
                    .mapToInt(Integer::parseInt)
                    .sum();
        }
        return Integer.parseInt(values);
    }

    private String parseDelimiter(String values) {
        if (values.contains(",")) {
            return ",";
        }
        if (values.contains("\n")) {
            return "\n";
        }
        return "";
    }
}
