package uk.co.rpl.exampleapi.services;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uk.co.rpl.exampleapi.dtos.User;
import uk.co.rpl.exampleapi.exceptions.NotFound;

/**
 *
 * @author philip
 */
@Service
@Slf4j
public class UserService {
    private final List<User> users;

    public UserService(){
        users = new ArrayList();
        users.add(new User("John", "Smith"));
        users.add(new User("Mary", "Jones"));
        users.add(new User("Jennifer", "Eccles"));
        users.add(new User("Jack", "Spratt"));
    }

    public User get(int id){
        log.debug("get({})", id);
        if (id>=users.size() || id < 0)
            throw new NotFound("Given index ("+id+") not found");
        var res = users.get(id);
        log.debug("Got user {}", res);
        return res;
    }

    public List<User> getUsers(){
        log.debug("get all users");
        return users;
    }


}
