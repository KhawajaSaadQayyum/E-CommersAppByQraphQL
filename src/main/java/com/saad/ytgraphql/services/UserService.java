package com.saad.ytgraphql.services;

import com.saad.ytgraphql.model.User;
import com.saad.ytgraphql.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    // Create User
    public User creareUser(User user) {
        return userRepo.save(user);
    }

    // get All users
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    // get Single User

    public User getUser(int userId) {
        User user = userRepo
                .findById(userId)
                .orElseThrow(() ->
                        new RuntimeException("No user found by this Eid"));
        return user;
    }

    // Delete User

    public boolean deleteUser(int userId){
        User user = userRepo
                .findById(userId)
                .orElseThrow(() ->
                        new RuntimeException("No user found by this Eid"));
        userRepo.delete(user);
        return true;
    }
}
