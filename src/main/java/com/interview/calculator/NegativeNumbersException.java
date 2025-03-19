package com.interview.calculator;

public class NegativeNumbersException extends RuntimeException {
    public String message;

    public NegativeNumbersException() {}

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
