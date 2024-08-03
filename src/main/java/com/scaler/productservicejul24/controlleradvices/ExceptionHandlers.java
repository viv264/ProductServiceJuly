package com.scaler.productservicejul24.controlleradvices;

import com.scaler.productservicejul24.dtos.ArithmeticExceptionDto;
import com.scaler.productservicejul24.dtos.ExceptionDto;
import com.scaler.productservicejul24.exceptions.ProductNotExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ArithmeticExceptionDto> handleArithmeticException(){
        ArithmeticExceptionDto arithmeticExceptionDto = new ArithmeticExceptionDto();
        arithmeticExceptionDto.setMessage("Something has gone wrong");
        return new ResponseEntity<>(arithmeticExceptionDto, HttpStatus.OK);
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<Void> arrayIndexOutOfBound(){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ExceptionHandler(ProductNotExistsException.class)
    public ResponseEntity<ExceptionDto> productNotExistsException(ProductNotExistsException exception){
        ExceptionDto dto = new ExceptionDto();
        dto.setMessage(exception.getMessage());
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
