package com.example.Empleados.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Empleados.model.TipoDeConductores;
import com.example.Empleados.services.TipoDeConductoresService;

import java.util.List;

@RestController
@RequestMapping("/employee/tipodeconductor")
public class TipoDeConductoresController {
    @Autowired
    private TipoDeConductoresService tipoDeConductoresService;

    @GetMapping
    public ResponseEntity<List<TipoDeConductores>> getAllTipoDeConductores() {
        return ResponseEntity.ok(tipoDeConductoresService.getAllTipoDeConductores());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoDeConductores> updateTipoDeConductores(@PathVariable Integer id, @RequestBody TipoDeConductores tipoDeConductores) {
        if (tipoDeConductoresService.getTipoDeConductoresById(id) != null) {
            tipoDeConductoresService.updateTipoDeConductores(id, tipoDeConductores);
            return new ResponseEntity<>(tipoDeConductores, HttpStatus.OK);
        }
        return new ResponseEntity<>(tipoDeConductores, HttpStatus.NOT_FOUND);
    }


    @GetMapping("/{id}")
    public ResponseEntity<TipoDeConductores> getTipoDeConductoresById(@PathVariable Integer id) {
        TipoDeConductores tipo = tipoDeConductoresService.getTipoDeConductoresById(id);
        if (tipo != null) {
            return new ResponseEntity<>(tipo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TipoDeConductores> deleteTipoDeConductoresById(@PathVariable Integer id) {
        TipoDeConductores tipo = tipoDeConductoresService.getTipoDeConductoresById(id);
        if (tipo!= null) {
            tipoDeConductoresService.deleteTipoDeConductores(id);
            return new ResponseEntity<>(tipo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<TipoDeConductores> createTipoDeConductores(@RequestBody TipoDeConductores tipoDeConductores) {
        tipoDeConductoresService.addTipoDeConductores(tipoDeConductores);
        return new ResponseEntity<>(tipoDeConductores, HttpStatus.CREATED);
    }
}
