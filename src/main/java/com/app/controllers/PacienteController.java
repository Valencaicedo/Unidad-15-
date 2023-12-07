package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.entities.PacienteEntity;
import com.app.repositories.PacienteRepository;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @GetMapping
    public ResponseEntity<List<PacienteEntity>> listarPacientes() {
        List<PacienteEntity> pacientes = pacienteRepository.findAll();
        return new ResponseEntity<>(pacientes, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PacienteEntity> agregarPaciente(@RequestBody PacienteEntity paciente) {
        PacienteEntity nuevoPaciente = pacienteRepository.save(paciente);
        return new ResponseEntity<>(nuevoPaciente, HttpStatus.CREATED);
    }

}
