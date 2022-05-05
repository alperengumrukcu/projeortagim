package com.projeortagim.projeortagim.Exception;

import com.projeortagim.projeortagim.Base.BaseResponse;
import com.projeortagim.projeortagim.Models.Users;
import org.springframework.http.ResponseEntity;

public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }

    public ValidationException() {
    }
}
