
package uk.co.rpl.exampleapi.dtos;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;


/**
 *
 * @author philip
 */
@AllArgsConstructor
@Builder
@Getter
@EqualsAndHashCode
@ToString
public class User {
    private final String firstName;
    private final String lastName;
}
