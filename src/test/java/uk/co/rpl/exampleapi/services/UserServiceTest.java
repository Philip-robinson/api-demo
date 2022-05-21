/*
 * 
 * 
 */
package uk.co.rpl.exampleapi.services;

import static org.assertj.core.api.Java6Assertions.assertThat;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import uk.co.rpl.exampleapi.exceptions.NotFound;

/**
 *
 * @author philip
 */
public class UserServiceTest {
    
    private UserService inst;

    @BeforeEach
    public void setUp() {
        inst = new UserService();
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of get method, of class UserService.
     */
    @Test
    public void testGet0() {
        System.out.println("testGet0");
        assertThat(inst.get(0))
                .extracting("firstName", "lastName")
                .containsExactly("John", "Smith");
    }

    @Test
    public void testGet3() {
        System.out.println("testGet3");
        assertThat(inst.get(3))
                .extracting("firstName", "lastName")
                .containsExactly("Jack", "Spratt");
    }

    @Test
    public void testGet4Exception() {
        System.out.println("testGet4Exception");
        var thrown = assertThrows(NotFound.class, ()->{
            assertThat(inst.get(4))
                    .extracting("firstName", "lastName")
                    .containsExactly("Jack", "Spratt");
        });
        assertThat(thrown).extracting("message")
                .isEqualTo("Given index (4) not found");
    }

    /**
     * Test of getUsers method, of class UserService.
     */
    @Test
    public void testGetUsers() {
        System.out.println("getUsers");
        var res = inst.getUsers();
        assertThat(res).asList().hasSize(4);
        assertThat(res.get(0)).extracting("firstName", "lastName")
                .containsExactly("John", "Smith");
        assertThat(res.get(3)).extracting("firstName", "lastName")
                .containsExactly("Jack", "Spratt");
    }
}
