package uk.co.rpl.exampleapi.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import uk.co.rpl.exampleapi.dtos.User;
import uk.co.rpl.exampleapi.services.UserService;

/**
 *
 * @author philip
 */
@RestController
@Api
@AllArgsConstructor
@Slf4j
public class UserController {

    public final UserService users;
    @ApiOperation("Get first user")
    @GetMapping("/api/main-user")
    public User getMainUser(){
        return users.get(0);
    }

    @ApiOperation("Get identified user")
    @GetMapping("/api/user/{id}")
    public User getUser(
        @PathVariable int id){
        log.debug("calling users.get({})", id);
        return users.get(id);
    }


    @ApiOperation("Get all users")
    @GetMapping("/api/users")
    public List<User> getAllUsers(){
        return users.getUsers();
    }
}
