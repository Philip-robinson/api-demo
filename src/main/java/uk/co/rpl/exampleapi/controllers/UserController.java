package uk.co.rpl.exampleapi.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import static java.util.Arrays.asList;
import java.util.List;
import java.util.stream.Collectors;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import uk.co.rpl.exampleapi.dtos.User;

/**
 *
 * @author philip
 */
@RestController
@Api
public class UserController {
    List<User> users = asList(
            "John Smith", "Mary Jones", "Jennifer Eccles", "Jack Spat")
            .stream()
            .map(us -> {
                var pair = us.split(" ");
                if (pair.length == 2) return new User(pair[0], pair[1]);
                return null;
            }).filter(a -> a != null)
            .collect(Collectors.toList());

    @ApiOperation("Get first user")
    @GetMapping("/api/main-user")
    public User getMainUser(){
        return users.get(0);
    }

    @ApiOperation("Get identified user")
    @GetMapping("/api/user/{id}")
    public User getMainUser(
        @PathVariable int id){
        if (id <0 || id >= users.size())
            throw new HttpClientErrorException(NOT_FOUND);
        return users.get(id);
    }


    @ApiOperation("Get all users")
    @GetMapping("/api/users")
    public List<User> getAllUsers(){
        return users;
    }
}
