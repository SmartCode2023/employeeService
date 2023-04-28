package com.example.Empleados.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Empleados.model.OperariosBodega;
import com.example.Empleados.repository.OperariosBodegaRepository;

import java.util.List;
@Service
public class OperariosBodegaService {
    @Autowired
    private OperariosBodegaRepository operariosBodegaRepository;


    public List<OperariosBodega> getAllOperariosBodega() {
        return operariosBodegaRepository.findAll();
    }

    public OperariosBodega getOperariosBodegaById(Integer id) {
        return operariosBodegaRepository.findById(id).orElse(null);
    }

    public void addOperariosBodega(OperariosBodega opbodega) {
        operariosBodegaRepository.save(opbodega);
    }

    public void updateOperariosBodega(Integer id, OperariosBodega opbodega) {
        operariosBodegaRepository.save(opbodega);

    }

    public void deleteOperariosBodega(Integer id) {
        operariosBodegaRepository.deleteById(id);
    }
}
