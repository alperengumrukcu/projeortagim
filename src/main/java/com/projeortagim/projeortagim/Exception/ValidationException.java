package com.projeortagim.projeortagim.Exception;

public class ValidationException extends RuntimeException{
    public ValidationException(String message) {
        super(message);
    }

    public ValidationException() {
    }
}
