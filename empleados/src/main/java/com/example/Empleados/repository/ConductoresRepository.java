package com.example.Empleados.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Empleados.model.Conductores;

public interface ConductoresRepository extends JpaRepository<Conductores, Integer>{
    
}
