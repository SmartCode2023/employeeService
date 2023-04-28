package com.example.Empleados.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Empleados.model.TipoDeConductores;
import com.example.Empleados.repository.TipoDeConductoresRepository;

import java.util.List;
@Service
public class TipoDeConductoresService {
    @Autowired
    private TipoDeConductoresRepository tipoDeConductoresRepository;


    public List<TipoDeConductores> getAllTipoDeConductores() {
        return tipoDeConductoresRepository.findAll();
    }

    public TipoDeConductores getTipoDeConductoresById(Integer id) {
        return tipoDeConductoresRepository.findById(id).orElse(null);
    }

    public void addTipoDeConductores(TipoDeConductores tipoDeConductores) {
        tipoDeConductoresRepository.save(tipoDeConductores);
    }

    public void updateTipoDeConductores(Integer id, TipoDeConductores tipoDeConductores) {
        tipoDeConductoresRepository.save(tipoDeConductores);
    }

    public void deleteTipoDeConductores(Integer id) {
        tipoDeConductoresRepository.deleteById(id);
    }
}
