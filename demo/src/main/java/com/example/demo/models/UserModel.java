package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "usuario")

//@ propiedades de los campos de la tabla para la BDD
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //se genera automaticamente
    @Column(unique = true, nullable = false) //autoincremental y unico
    private Long id;

    private String nombre;
    private String email;
    private Integer prioridad;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Integer getPrioridad() {
        return prioridad;
    }
    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }

    
}
