package com.exampleSpringBootApi.services;

import java.util.*;

import com.exampleSpringBootApi.models.UserModel;
import com.exampleSpringBootApi.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserService {
    
    @Autowired
    UserRepository userRepository;
    
    public ArrayList<UserModel> getUsers(){
        return (ArrayList<UserModel>) userRepository.findAll();
    }

    public UserModel saveUser(UserModel usuario){
        return userRepository.save(usuario);
    }

    public Optional<UserModel> getById(Long id){
        return userRepository.findById(id);
    }


    public ArrayList<UserModel>  getByPriority(Integer prioridad) {
        return userRepository.findByPriority(prioridad);
    }

    public boolean eliminarUsuario(Long id) {
        try{
            userRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }


    
}