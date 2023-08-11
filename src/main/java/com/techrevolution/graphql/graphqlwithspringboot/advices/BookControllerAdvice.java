package com.techrevolution.graphql.graphqlwithspringboot.advices;

import com.techrevolution.graphql.graphqlwithspringboot.exceptions.ErrorMessage;
import com.techrevolution.graphql.graphqlwithspringboot.exceptions.NoRecordFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestControllerAdvice
public class BookControllerAdvice extends ResponseEntityExceptionHandler {

//    @ExceptionHandler(value = NoRecordFoundException.class)
//    public ResponseEntity<Object> handleEmptyBookRecord(NoRecordFoundException recordFoundException) {
//        return new ResponseEntity<>(recordFoundException, HttpStatus.NOT_FOUND);
//    }

    @ExceptionHandler(value = {NoRecordFoundException.class})
    public ResponseEntity<ErrorMessage> resourceNotFoundException(NoRecordFoundException ex, WebRequest request) {
        ErrorMessage message = new ErrorMessage(
                HttpStatus.NOT_FOUND.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }
}
