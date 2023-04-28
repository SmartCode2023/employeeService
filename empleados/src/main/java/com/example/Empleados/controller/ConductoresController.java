package com.example.Empleados.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Empleados.model.Conductores;
import com.example.Empleados.model.TipoDeConductores;
import com.example.Empleados.services.ConductoresService;
import com.example.Empleados.services.TipoDeConductoresService;

import java.util.List;

@RestController
@RequestMapping("/employee/conductor")
public class ConductoresController {
    
    @Autowired
    private TipoDeConductoresService tipoDeConductoresService;

    @Autowired
    private ConductoresService conductoresService;

    @GetMapping
    public ResponseEntity<List<Conductores>> getAllConductores() {
        return ResponseEntity.ok(conductoresService.getAllConductores());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conductores> getConductoresById(@PathVariable Integer id) {
        Conductores conductor = conductoresService.getConductoresById(id);
        if (conductor != null) {
            return new ResponseEntity<>(conductor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Conductores> createConductores(@RequestBody Conductores conductor) {
        TipoDeConductores tipoDeConductores = tipoDeConductoresService.getTipoDeConductoresById(conductor.getTipoDeConductorId());
        if (tipoDeConductores!= null ){
            conductoresService.addConductores(conductor);
            return new ResponseEntity<>(conductor, HttpStatus.CREATED);

        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Conductores> deleteConductoresById(@PathVariable Integer id) {
        Conductores conduct = conductoresService.getConductoresById(id);
        if (conduct!= null) {
            conductoresService.deleteConductores(id);
            return new ResponseEntity<>(conduct, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Conductores> updateConductores(@PathVariable Integer id, @RequestBody Conductores conductor) {
        if (conductoresService.getConductoresById(id) != null) {
            TipoDeConductores tipoDeConductores = tipoDeConductoresService.getTipoDeConductoresById(conductor.getTipoDeConductorId());
            if (tipoDeConductores!= null){
                conductoresService.updateConductores(id, conductor);
                return new ResponseEntity<>(conductor, HttpStatus.CREATED);

            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    } 
}
