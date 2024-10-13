package co.pragra.productmanager.arpitspringboottask.Service;

import co.pragra.productmanager.arpitspringboottask.Entity.User;
import co.pragra.productmanager.arpitspringboottask.Exception.InvalidUserInformation;
import co.pragra.productmanager.arpitspringboottask.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    //creating new user
    public User creatUser(User user) throws InvalidUserInformation {

        if(user==null )
        {
            System.out.println("User can not be null");
        }
        if(user.getUserName()==null || user.getUserName().isEmpty())
        {
            throw new InvalidUserInformation("User can not be null");
        }
        if(user.getEmail()==null || user.getEmail().isEmpty())
        {
            throw new InvalidUserInformation("User Email can not be null");
        }

        //so you can write business logic here for everyfield i am writing only for two.

        return userRepository.save(user);
    }

    //getting all user
    public List<User> getAlluser() {
        return userRepository.findAll();
    }

    //get by id
    public Optional<User> findById(Integer id) {

        return userRepository.findById(id);
    }

    //updating user
    public User updateUser(User user, Integer id) throws InvalidUserInformation {
        Optional<User> optionalUser = userRepository.findById(id);
        optionalUser.orElseThrow(() -> new InvalidUserInformation("User doesn't exist."));

        User dbUser=optionalUser.get();
        dbUser.setUserName(user.getUserName());
        dbUser.setEmail(user.getEmail());
        dbUser.setFirstName(user.getFirstName());
        dbUser.setLastName(user.getLastName());
        dbUser.setPhoneNumber(user.getPhoneNumber());

        return userRepository.save(dbUser);
    }

    public void deletByid(Integer id) throws InvalidUserInformation {

        Optional<User> optionalUser = userRepository.findById(id);
        optionalUser.orElseThrow(() -> new InvalidUserInformation("User doesn't exist."));

        userRepository.deleteById(id);
    }
}
