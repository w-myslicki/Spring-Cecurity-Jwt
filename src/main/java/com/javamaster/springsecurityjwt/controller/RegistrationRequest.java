package com.javamaster.springsecurityjwt.controller;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class RegistrationRequest {

    private String login;
    private String password;
}
