package com.example.demo.controllers;

import com.example.demo.models.UserModel;
import com.example.demo.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
     UserService userService;

    @GetMapping()
    public ArrayList<UserModel> getUsers(){
        return userService.getAllUsers();
    }

    @GetMapping(path = "/{id}")
    public Optional<UserModel> getById(@PathVariable("id") Long id){ //optional por si falla o el id no existe
        return this.userService.getById(id);
    }

    @PostMapping()
    public UserModel saveUser(@RequestBody UserModel user){
        return this.userService.saveUser(user);
    }

    @DeleteMapping (path = "/{id}")
    public String deleteById(@PathVariable("id") Long id){
        boolean ok = this.userService.deleteUser(id);
        if (ok){
            return "User id " + id + " was deleted successfully";
        } else {
            return "Can't delete user id " + id;
        }
    }

    @GetMapping("/priority")
    public ArrayList<UserModel>getByPriority(@RequestParam("priority") Integer priority){
        return this.userService.getByPriority(priority);
    }

    @GetMapping("/priorityGreater")
    public ArrayList<UserModel>getByPriorityGreaterThan(@RequestParam("priorityGreaterThan") Integer priority){
        return this.userService.getPriorityGreaterThan(priority);
    }

    @GetMapping("/email")
    public UserModel getByEmail(@RequestParam("email") String email){
        return this.userService.getByEmail(email);
    }

    @GetMapping("/name")
    public UserModel getByName(@RequestParam("name") String name){
        return this.userService.getByName(name);
    }

    @GetMapping("/nameContains")
    public ArrayList<UserModel> getByNameContaining(@RequestParam("name") String name){
        return this.userService.getNameContaining(name);
    }




}
