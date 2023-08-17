package com.cielazure.board.Controller;

import com.cielazure.board.Model.Board;
import com.cielazure.board.Model.User;
import com.cielazure.board.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserApiController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    List<User> all() {
        return userRepository.findAll();
    }


//    @PostMapping("/users")
//    User newUser(@RequestBody User newUser) {
//        return userRepository.save(newUser);
//    }

    // Single item

//    @GetMapping("/users/{id}")
//    User one(@PathVariable Long id) {
//        return userRepository.findById(id).orElse(null);
//    }



//    @DeleteMapping("/users/{id}")
//    void deleteUser(@PathVariable Long id) {
//        userRepository.deleteById(id);
//    }
}
