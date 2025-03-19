package com.interview.calculator;

import java.util.Arrays;

public class Calculator {
    public int add(String values) {
        if (values == null || values.isEmpty()) {
            return 0;
        }

        String delimiter = parseDelimiter(values);
        if (delimiter.isEmpty()) {
            int parsedValue = Integer.parseInt(values);
            if (parsedValue >= 0) {
                return Integer.parseInt(values);
            } else {
                throw new NegativeNumbersException();
            }
        } else {
            String cleanValues = cleanDelimiters(values, delimiter);
            String[] separateValues = cleanValues.split(delimiter);
            int[] parsedInts = Arrays.stream(separateValues)
                    .mapToInt(Integer::parseInt)
                    .toArray();

            Arrays.stream(parsedInts)
                    .filter(value -> value < 0)
                    .findAny()
                    .ifPresent(value -> {
                        throw new NegativeNumbersException();
                    });

            return Arrays.stream(parsedInts)
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
