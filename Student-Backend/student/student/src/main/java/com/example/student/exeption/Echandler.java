package com.example.student.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Echandler {

    @ExceptionHandler(Userfound.class)
    public ResponseEntity<String> handle(Userfound uf){
        return new ResponseEntity<>(uf.getMessage(),HttpStatus.CONFLICT);
    }
    @ExceptionHandler(Usernotfound.class)
    public ResponseEntity<String> usernot(Usernotfound unf){
        return new ResponseEntity<>(unf.getMessage(),HttpStatus.NOT_FOUND);
    }

}
