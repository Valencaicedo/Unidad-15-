package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.entities.DoctorEntity;
import com.app.repositories.DoctorRepository;

import java.util.List;

@RestController
@RequestMapping("/doctores")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping
    public ResponseEntity<List<DoctorEntity>> listarDoctores() {
        List<DoctorEntity> doctores = doctorRepository.findAll();
        return new ResponseEntity<>(doctores, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DoctorEntity> agregarDoctor(@RequestBody DoctorEntity doctor) {
        DoctorEntity nuevoDoctor = doctorRepository.save(doctor);
        return new ResponseEntity<>(nuevoDoctor, HttpStatus.CREATED);
    }


}
