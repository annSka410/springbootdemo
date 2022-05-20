package com.example.springbootdemo.service;

import com.example.springbootdemo.model.User;
import com.example.springbootdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

//    List<User> users = new ArrayList<>();
//    private final static Long part = 1l;

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(Long id) {
//        return users.stream().filter(user -> id.equals(user.getId())).findFirst().orElse(null);
        return userRepository.getById(id);
    }

    public List<User> findAll() {
//        if (users.isEmpty()) {
//            users.add(new User(1L, "Anna", "Skachkova"));
//            users.add(new User(2L, "Tanya", "Ivanova"));
//            users.add(new User(3L, "Masha", "Petrova"));
//            return users;
//        } else {
//            return users;
//        }
        return userRepository.findAll();
    }

    public User saveUser(User newUser) {
//        if (newUser.getId() == null) {
//            Long id = users.stream().map(User::getId).max(Comparator.naturalOrder()).orElse(null);
//            newUser.setId(part + id);
//            users.add(newUser);
//            return newUser;
//        }
//
//        User userFromList = users.stream().
//                filter(user -> newUser.getId().equals(user.getId())).
//                findFirst().
//                orElse(null);
//
//        userFromList.setId(newUser.getId());
//        userFromList.setFirstName(newUser.getFirstName());
//        userFromList.setLastName(newUser.getLastName());
//
//        return userFromList;
        return userRepository.save(newUser);
    }

    public void deleteUserById(Long id) {
//        users.removeIf(user -> id.equals(user.getId()));
        userRepository.deleteById(id);
    }
}
