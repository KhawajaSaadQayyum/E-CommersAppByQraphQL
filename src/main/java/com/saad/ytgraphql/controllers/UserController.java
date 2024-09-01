package com.saad.ytgraphql.controllers;

import com.saad.ytgraphql.model.User;
import com.saad.ytgraphql.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @MutationMapping
    private User createUser(@Argument String name, @Argument String phone, @Argument String email, @Argument String password) {
        User user = new User();
        user.setName(name);
        user.setPhone(phone);
        user.setPassword(password);
        user.setEmail(email);

        return userService.creareUser(user);
    }

    @QueryMapping
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @QueryMapping
    public User getUser(@Argument int userID) {
        return userService.getUser(userID);

    }
    @MutationMapping
    public boolean deleteUser(@Argument int userId){
        return userService.deleteUser(userId);
    }
}
