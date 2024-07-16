package com.LaptopAdda.project.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = CategoryNotFoundException.class)
    public ResponseEntity<APIError> handleCategoryNotFoundException(){
        APIError error=new APIError(400,"No Category Found");
        return new ResponseEntity<APIError>(error,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value=ProductNotFoundException.class)
    public ResponseEntity<APIError> handleProductNotFoundException(){
    APIError error=new APIError(400,"No Product Found");
    return new ResponseEntity<APIError>(error,HttpStatus.BAD_REQUEST);}

}
