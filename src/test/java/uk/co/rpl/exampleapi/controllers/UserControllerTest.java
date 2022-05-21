/*
 * 
 * 
 */
package uk.co.rpl.exampleapi.controllers;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import uk.co.rpl.exampleapi.dtos.User;
import uk.co.rpl.exampleapi.exceptions.NotFound;
import uk.co.rpl.exampleapi.services.UserService;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

/**
 *
 * @author philip
 */
public class UserControllerTest {
    
    private UserService service;
    private UserController inst;

    private static final String FIRST_1="usernumberone";
    private static final String FIRST_2="Second-User";
    private static final String SECOND_1="2nd Name";
    private static final String SECOND_2="Second-2nd Name";

    private List<User> users;

    private static final int MAIN_INDEX=0;
    private static final int GOOD_INDEX=1;
    private static final int BAD_INDEX=4;

    private MockMvc mvc;

    @BeforeEach
    public void setUpClass() {
        service = mock(UserService.class);
        inst = new UserController(service);
        users = Arrays.asList(new User(FIRST_1, SECOND_1),
                       new User(FIRST_2, SECOND_2));
        when(service.getUsers()).thenReturn(users);
        when(service.get(MAIN_INDEX)).thenReturn(new User(FIRST_2, SECOND_2));
        when(service.get(GOOD_INDEX)).thenReturn(new User(FIRST_1, SECOND_1));
        when(service.get(BAD_INDEX)).thenThrow(new NotFound("NOT_FOUND"));

        mvc = MockMvcBuilders
                .standaloneSetup(inst)
                .setControllerAdvice(new ExceptionHandlers())
                .build();
    }
    
    /**
     * Test of getMainUser method, of class UserController.
     */
    @Test
    public void testGetMainUser() throws Exception {
        System.out.println("getMainUser");
        mvc.perform(get("/api/main-user"))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.firstName").value(FIRST_2))
                .andExpect(jsonPath("$.lastName").value(SECOND_2));
    }

    /**
     * Test of getUser method, of class UserController.
     */
    @Test
    public void testGetUser() throws Exception {
        System.out.println("getUser");
        mvc.perform(get("/api/user/"+GOOD_INDEX))
                .andExpect(status().is(200))
                .andDo(print())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.firstName").value(FIRST_1))
                .andExpect(jsonPath("$.lastName").value(SECOND_1));
    }

    @Test
    public void testGetUserBadIndex() throws Exception {
        System.out.println("getUser");
        mvc.perform(get("/api/user/"+BAD_INDEX))
                .andExpect(status().is(404))
                .andDo(print());
    }

    /**
     * Test of getAllUsers method, of class UserController.
     */
    @Test
    public void testGetAllUsers() throws Exception {
        System.out.println("getAllUsers");
        mvc.perform(get("/api/users"))
                .andExpect(status().is(200))
                .andDo(print())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.[0].firstName").value(FIRST_1))
                .andExpect(jsonPath("$.[1].lastName").value(SECOND_2));
    }
    
}
