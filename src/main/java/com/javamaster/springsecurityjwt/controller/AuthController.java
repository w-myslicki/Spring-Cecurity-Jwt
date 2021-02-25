package com.javamaster.springsecurityjwt.controller;

import com.javamaster.springsecurityjwt.config.jwt.JwtProvider;
import com.javamaster.springsecurityjwt.entity.UserEntity;
import com.javamaster.springsecurityjwt.repository.UserEntityRepository;
import com.javamaster.springsecurityjwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    private UserEntityRepository userEntityRepository;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegistrationRequest registrationRequest) {
        try {
            UserEntity u = new UserEntity();
            u.setPassword(registrationRequest.getPassword());
            u.setLogin(registrationRequest.getLogin());
            userService.saveUser(u);
            return new ResponseEntity<>("Success!",HttpStatus.OK);

        } catch (Exception exception) {
            return new ResponseEntity<>("Error: "+exception,HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/auth")
    public AuthResponse auth(@RequestBody AuthRequest request) {
        UserEntity userEntity = userService.findByLoginAndPassword(request.getLogin(), request.getPassword());
        String token = jwtProvider.generateToken(userEntity.getLogin());
        return new AuthResponse(token);
    }


    //--------------------------Simple core controllers-----------------------

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
