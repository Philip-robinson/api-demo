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
        log.info("called /api/main-user");
        var res = users.get(0);
        log.debug("/api/main-user returns {}", res);
        return res;
    }

    @ApiOperation("Get identified user")
    @GetMapping("/api/user/{id}")
    public User getUser(
        @PathVariable int id){
        log.info("called /api/user/{}", id);
        var res = users.get(id);
        log.debug("/api/users/{} reurned {}", id, res);
        return res;
    }


    @ApiOperation("Get all users")
    @GetMapping("/api/users")
    public List<User> getAllUsers(){
        log.info("called /api/users");
        var res = users.getUsers();
        log.debug("/api/users returned {}", res);
        return res;
    }
}
