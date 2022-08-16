package com.eva.shop.configuration;

import com.eva.shop.exceptions.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class Handler {

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<Object> handle(ValidationException ex,
                                         HttpServletRequest request, HttpServletResponse response) {
        return new ResponseEntity<>(ex.getValidationExceptionMessage() ,HttpStatus.BAD_REQUEST);
    }
}
