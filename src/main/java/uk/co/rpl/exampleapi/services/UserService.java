package uk.co.rpl.exampleapi.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import uk.co.rpl.exampleapi.dtos.User;
import uk.co.rpl.exampleapi.exceptions.NotFound;

/**
 *
 * @author philip
 */
@Service
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
        if (id>=users.size() || id < 0)
            throw new NotFound("Given index ("+id+") not found");
        return(users.get(id));
    }

    public List<User> getUsers(){
        return users;
    }
}