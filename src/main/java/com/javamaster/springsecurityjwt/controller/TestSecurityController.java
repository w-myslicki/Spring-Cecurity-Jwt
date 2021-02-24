package com.javamaster.springsecurityjwt.controller;

import com.javamaster.springsecurityjwt.entity.UserEntity;
import com.javamaster.springsecurityjwt.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class TestSecurityController {

    @Autowired
    private UserEntityRepository userEntityRepository;

    @GetMapping("/admin/get")
    public String getAdmin() {
        return "Hi admin";
    }

    @GetMapping("/user/get")
    public List<UserEntity> getAllUsers() {
        List<UserEntity> usersList = new ArrayList<>();

        Iterable<UserEntity> iterable = userEntityRepository.findAll();
        iterable.forEach(usersList::add);
        return usersList;
    }
}
