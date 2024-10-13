package co.pragra.productmanager.arpitspringboottask.RestController;

import co.pragra.productmanager.arpitspringboottask.Entity.User;
import co.pragra.productmanager.arpitspringboottask.Exception.InvalidUserInformation;
import co.pragra.productmanager.arpitspringboottask.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserRestController {


    @Autowired
    private UserService userService;

    //creating new user
    @PostMapping("/users")
    public User creatNewUser(@RequestBody User user) throws InvalidUserInformation {

        return userService.creatUser(user);
    }

    //getting all the user
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAlluser();
    }

    //getting user by id
    @GetMapping("/users/{id}")
    public Optional<User> getUserById(@PathVariable("id") Integer id) throws InvalidUserInformation {

        Optional<User> user = userService.findById(id);
        user.orElseThrow(() -> new InvalidUserInformation("User doesn't exist."));
        return user;
    }

    //updating record
    @PutMapping("/users/{id}")
    public User updateUser(@RequestBody User user,@PathVariable("id") Integer id) throws InvalidUserInformation {
        return userService.updateUser(user,id);
    }

    //deleting record
    @DeleteMapping("/users/{id}")
    public void deletUser(@PathVariable("id") Integer id) throws InvalidUserInformation {

        userService.deletByid(id);
    }
}
