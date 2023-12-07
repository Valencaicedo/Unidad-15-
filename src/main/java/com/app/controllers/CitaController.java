package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.entities.CitaEntity;
import com.app.repositories.CitaRepository;

import java.util.List;

@RestController
@RequestMapping("/citas")
public class CitaController {

    @Autowired
    private CitaRepository citaRepository;

    @GetMapping
    public ResponseEntity<List<CitaEntity>> listarCitas() {
        List<CitaEntity> citas = citaRepository.findAll();
        return new ResponseEntity<>(citas, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CitaEntity> agregarCita(@RequestBody CitaEntity cita) {
        CitaEntity nuevaCita = citaRepository.save(cita);
        return new ResponseEntity<>(nuevaCita, HttpStatus.CREATED);
    }


}
