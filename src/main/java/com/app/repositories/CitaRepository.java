package com.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.CitaEntity;

@Repository
public interface CitaRepository extends JpaRepository<CitaEntity, Long> {
}
