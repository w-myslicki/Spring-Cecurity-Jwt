//package com.javamaster.springsecurityjwt.config;
//
//import com.javamaster.springsecurityjwt.config.Exceptions.ErrorsValidation;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
//import java.util.Date;
//
//@ControllerAdvice
//public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    protected ResponseEntity<Object> customValidationErrorHandling(MethodArgumentNotValidException exception) {
//
//        ErrorsValidation errorValidation  = new ErrorsValidation(new Date(), "Validation error",
//                exception.getBindingResult().getFieldError().getDefaultMessage());
//
//        return new ResponseEntity<>(errorValidation, HttpStatus.BAD_REQUEST);
//    }
//}
