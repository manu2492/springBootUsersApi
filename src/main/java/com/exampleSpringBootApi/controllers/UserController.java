package com.exampleSpringBootApi.controllers;

import java.util.*;

import com.exampleSpringBootApi.models.UserModel;
import com.exampleSpringBootApi.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    UserService userService;

    @GetMapping()
    public ArrayList<UserModel> obtenerUsuarios(){
        return userService.getUsers();
    }

    @PostMapping()
    public UserModel saveUser(@RequestBody UserModel user){
        return this.userService.saveUser(user);
    }

    @GetMapping( path = "/{id}")
    public Optional<UserModel> obtenerUsuarioPorId(@PathVariable("id") Long id) {
        return this.userService.getById(id);
    }

    @GetMapping("/query")
    public ArrayList<UserModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad){
        return this.userService.getByPriority(prioridad);
    }

    @DeleteMapping( path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.userService.eliminarUsuario(id);
        if (ok){
            return "user deleted " + id;
        }else{
            return "error" + id;
        }
    }

    
}
