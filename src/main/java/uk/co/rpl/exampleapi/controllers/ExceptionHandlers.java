/*
 *
 *
 */
package uk.co.rpl.exampleapi.controllers;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import uk.co.rpl.exampleapi.exceptions.NotFound;

/**
 *
 * @author philip
 */
@ControllerAdvice
public class ExceptionHandlers {
    @ExceptionHandler({NotFound.class})
    public ResponseEntity<String> handleNotFound(Exception e){
        return new ResponseEntity<>("""
                                    {
                                        "message": "{msg}"
                                    }
                                    """.replace("{msg}", e.getMessage()),
                                    NOT_FOUND);
    }
    @ExceptionHandler({Throwable.class})
    public ResponseEntity<String> handleGenException(Throwable e){
        return new ResponseEntity<>("""
                                    {
                                        "message": "{msg}"
                                    }
                                    """.replace("{msg}", e.getMessage()),
                                    INTERNAL_SERVER_ERROR);
    }
}
