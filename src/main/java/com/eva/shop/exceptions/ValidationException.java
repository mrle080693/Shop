package com.eva.shop.exceptions;

public class ValidationException extends RuntimeException {
    private String validationExceptionMessage;

    public ValidationException(String validationExceptionMessage) {
        this.validationExceptionMessage = validationExceptionMessage;
    }

    public String getValidationExceptionMessage() {
        return validationExceptionMessage;
    }
}
