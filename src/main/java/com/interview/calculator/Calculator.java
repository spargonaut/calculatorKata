package com.interview.calculator;

import java.util.Arrays;

public class Calculator {
    public int add(String values) {
        if (values == null || values.isEmpty()) {
            return 0;
        }

        String delimiter = parseDelimiter(values);
        if (delimiter.isEmpty()) {
            return Integer.parseInt(values);
        } else {
            String cleanValues = cleanDelimiters(values, delimiter);
            String[] separateValues = cleanValues.split(delimiter);
            return Arrays.stream(separateValues)
                    .mapToInt(Integer::parseInt)
                    .sum();
        }
    }

    private String parseDelimiter(String values) {
        if (values.startsWith("//")) {
            return values.substring(2, 3);
        } else if (values.contains(",") || values.contains("\n")) {
            return ",";
        }
        return "";
    }

    private String cleanDelimiters(String values, String delimiter) {
        String delimiterPrefix = "//" + delimiter + "\n";
        String valuesPrefixRemoved = values.replaceFirst(delimiterPrefix, "");
        return valuesPrefixRemoved.replace("\n", delimiter);
    }
}
