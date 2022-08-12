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
    public Optional<UserModel> getUserById(@PathVariable("id") Long id){ //optional por si falla o el id no existe
        return this.userService.getById(id);
    }

    @PostMapping()
    public UserModel saveUser(@RequestBody UserModel user){
        return this.userService.saveUser(user);
    }

    @DeleteMapping (path = "/{id}")
    public String deleteUserById(@PathVariable("id") Long id){
        boolean ok = this.userService.deleteUser(id);
        if (ok){
            return "User id " + id + " was deleted successfully";
        } else {
            return "Can't delete user id " + id;
        }
    }

    @GetMapping(path = "/priority")
    public ArrayList<UserModel>getUserByPriority(@RequestParam("priority") Integer priority){
        return this.userService.getByPriority(priority);
    }

    @GetMapping(path = "/priorityGreater")
    public ArrayList<UserModel>getUserByPriorityGreaterThan(@RequestParam("greaterThan") Integer priority){
        return this.userService.getPriorityGreaterThan(priority);
    }

    @GetMapping("/email")
    public ArrayList<UserModel> getUserByEmail(@RequestParam("email") String email){
        return this.userService.getByEmail(email);
    }

    @GetMapping("/name")
    public ArrayList<UserModel> getUserByName(@RequestParam("name") String name){
        return this.userService.getByName(name);
    }

    @GetMapping("/nameContains")
    public ArrayList<UserModel> getUserByNameContaining(@RequestParam("name") String name){
        return this.userService.getNamesContaining(name);
    }
}
