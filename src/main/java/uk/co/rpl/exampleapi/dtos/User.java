
package uk.co.rpl.exampleapi.dtos;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;


/**
 *
 * @author philip
 */
@AllArgsConstructor
@Builder
@Getter
public class User {
    private final String firstName;
    private final String lastName;
}
