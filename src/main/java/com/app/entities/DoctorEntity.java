package com.app.entities;

import javax.persistence.*;

@Entity
@Table(name = "doctores")
public class DoctorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String especialidad; 
    private String consultorio;
    private String correo;

    public DoctorEntity() {
    }

    //  parametros
    public DoctorEntity(String nombre, String apellido, String especialidad, String consultorio, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
        this.consultorio = consultorio;
        this.correo = correo;
    }

    // Getters y setters

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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(String consultorio) {
        this.consultorio = consultorio;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
