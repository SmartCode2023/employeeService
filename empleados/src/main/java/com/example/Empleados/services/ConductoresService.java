package com.example.Empleados.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.example.Empleados.model.Conductores;
import com.example.Empleados.repository.ConductoresRepository;
@Service
public class ConductoresService {
    @Autowired
    private ConductoresRepository conductoresRepository;


    public List<Conductores> getAllConductores() {
        return conductoresRepository.findAll();
    }

    public Conductores getConductoresById(Integer id) {
        return conductoresRepository.findById(id).orElse(null);
    }

    public void addConductores(Conductores conduct) {
        conductoresRepository.save(conduct);
    }

    public void updateConductores(Integer id, Conductores conduct) {
        conductoresRepository.save(conduct);

    }

    public void deleteConductores(Integer id) {
        conductoresRepository.deleteById(id);
    }
}
