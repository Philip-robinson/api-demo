/*
 * 
 * 
 */
package uk.co.rpl.exampleapi.controllers;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpClientErrorException.NotFound;

/**
 *
 * @author philip
 */
@ControllerAdvice
public class ExceptionHandlers {
    @ExceptionHandler({HttpClientErrorException.class, NotFound.class})
    public ResponseEntity<String> handleNotFound(Exception e){
        return new ResponseEntity<>("""
                                    {
                                        "message": "Not found"
                                    }
                                    """,NOT_FOUND);
    }
}
