package com.projeortagim.projeortagim.Exception;

import com.projeortagim.projeortagim.Base.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = ValidationException.class)
    public ResponseEntity<BaseResponse<?>> validationExceptionHandler(ValidationException e){
        BaseResponse response = new BaseResponse();
        response.setMessages("Validation Error...");
        response.setSuccess(false);
        response.setData(null);
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }
   /* @ExceptionHandler(value = Exception.class)
   public ResponseEntity<BaseResponse<?>> exception(){
        BaseResponse response = new BaseResponse();
        response.setMessages("Bilinmeyen bir hata oluştu...");
        response.setSuccess(false);
        response.setData(null);
        return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }*/}
