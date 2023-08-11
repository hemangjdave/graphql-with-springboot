package com.techrevolution.graphql.graphqlwithspringboot.exceptions;

import lombok.Builder;

@Builder
public class NoRecordFoundException extends RuntimeException {
    private final String errorCode;
    private final String errorMessage;

    public NoRecordFoundException(String errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
