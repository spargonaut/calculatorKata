package com.interview.calculator;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.interview.calculator.Constants.*;

@SpringBootApplication
public class CalculatorApplication implements CommandLineRunner
{

    public static void main(String[] args)
    {
        SpringApplication.run(CalculatorApplication.class, args);
    }

    @Override
    public void run(String... args)
    {
        if (args == null || args.length == 0) {
            System.out.println(THE_RESULT_FOR_THE_SUM_IS + 0);
        } else {
            try {
                int result = calculator(args[0]);
                System.out.println(THE_RESULT_FOR_THE_SUM_IS + result);
            } catch (NegativeNumbersException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(AT_LEAST_ONE_VALUE_CAN_T_BE_CONVERTED_TO_A_NUMBER);
            }
        }
    }

    private int calculator(String inputValue) throws Exception
    {
        if (inputValue.isEmpty()) {
            return 0;
        } else if (inputValue.length() == 1) {
            if (isNumber(inputValue)) {
                return Integer.parseInt(inputValue);
            }
        }

        String delimiter = ",";
        if (inputValue.contains(START)) {
            if (!inputValue.contains("[")) {

                delimiter = ";";
                inputValue = inputValue.replace(NEW_LINE, delimiter).replace(START, EMPTY_STRING);
            } else {
                String delimiters = inputValue
                        .substring(inputValue.indexOf(START) + 2, inputValue.indexOf(NEW_LINE))
                        .replace("][", EMPTY_STRING);
                String data = inputValue.substring(inputValue.indexOf(NEW_LINE) + 2);
                delimiter = delimiters;
                inputValue = data;
            }
        } else {
            inputValue = inputValue.replace(NEW_LINE, delimiter);
        }

        List<String> values = Arrays.asList(inputValue.split(delimiter));

        if (isNumber(values)) {
            values = values.stream()
                    .filter(value -> !value.isEmpty() && Integer.parseInt(value) <= MAX_INT_ALLOWED)
                    .collect(Collectors.toList());

            List<String> negativeValues = values.stream()
                    .filter(value -> Integer.parseInt(value) < 0)
                    .toList();

            try {
                if (!negativeValues.isEmpty()) {
                    throw new NegativeNumbersException();
                }

                return sum(values);
            } catch (NegativeNumbersException e) {
                e.setMessage(NEGATIVES_NOT_ALLOWED + negativeValues);
                throw e;
            }
        }

        throw new Exception();
    }

    private int sum(List<String> values) {
        int result = 0;
        for (String value : values) {
            int valueInt = Integer.parseInt(value);
            result = result + valueInt;
        }

        return result;
    }

    private boolean isNumber(List<String> values) throws NumberFormatException {
        boolean areNumbers = true;
        for (String value : values) {
            try {
                isNumber(value);
            } catch (NumberFormatException e) {
                areNumbers = false;
                break;
            }
        }

        return areNumbers;
    }

    private boolean isNumber(String value) throws NumberFormatException {
        if (value.isEmpty()) {
            return false;
        }

        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}