package com.example.demo.repositories;

import com.example.demo.models.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {
    public abstract ArrayList<UserModel> findByPrioridad(Integer priority);
    public abstract ArrayList<UserModel> findByPrioridadGreaterThan(Integer priority);
    public abstract ArrayList<UserModel> findByEmail(String email);
    public abstract ArrayList<UserModel> findByNombre(String name);
    public abstract ArrayList<UserModel> findAllByNombreContains(String name);

}

