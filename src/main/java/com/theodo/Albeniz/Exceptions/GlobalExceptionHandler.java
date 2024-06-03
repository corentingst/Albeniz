package com.theodo.Albeniz.Exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UnknownMusicId.class)
    public ResponseEntity<String> handleBadRequestException(UnknownMusicId unknownMusicIdException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(unknownMusicIdException.getMessage());
    }
}
