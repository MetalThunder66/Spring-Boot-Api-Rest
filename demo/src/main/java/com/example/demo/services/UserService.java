package com.example.demo.services;

import com.example.demo.models.UserModel;
import com.example.demo.repositories.UserRepository;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public ArrayList<UserModel>getAllUsers(){
        return (ArrayList<UserModel>) userRepository.findAll();
    }

    public Optional<UserModel> getById(Long id){ //optional por si falla o el id no existe
        return userRepository.findById(id);
    }

    public UserModel saveUser(UserModel user){
        return userRepository.save(user);
    }

    public boolean deleteUser(Long id){
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public ArrayList<UserModel>getByPriority(Integer priority){
        return (ArrayList<UserModel>) userRepository.findByPrioridad(priority);
    }

    public ArrayList<UserModel>getPriorityGreaterThan(Integer priority){
        return (ArrayList<UserModel>) userRepository.findByPrioridadGreaterThan(priority);
    }

    public ArrayList<UserModel> getByEmail(String email) {
        return (ArrayList<UserModel>) userRepository.findByEmail(email);
    }

    public ArrayList<UserModel> getByName(String name){
        return (ArrayList<UserModel>) userRepository.findByNombre(name);
    }

    public ArrayList<UserModel> getNamesContaining(String name){
        return (ArrayList<UserModel>) userRepository.findAllByNombreContains(name);
    }
}


