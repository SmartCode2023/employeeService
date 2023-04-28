package com.example.Empleados.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Empleados.model.TipoDeConductores;

public interface TipoDeConductoresRepository extends JpaRepository<TipoDeConductores, Integer> {
    
}
