package uk.co.rpl.exampleapi.exceptions;

/**
 *
 * @author philip
 */
public class NotFound extends RuntimeException{

    public NotFound(String message) {
        super(message);
    }
    
}
