package edu.projetocomjpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.projetocomjpa.model.User;
import edu.projetocomjpa.service.UserService;

@RestController
public class UserController {

    @Autowired
    UserService users;

    @GetMapping
    public List<User> index(){
        return users.findAll();
    }
}
