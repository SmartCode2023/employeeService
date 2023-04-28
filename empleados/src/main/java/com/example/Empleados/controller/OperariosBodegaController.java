package com.example.Empleados.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Empleados.model.OperariosBodega;
import com.example.Empleados.services.OperariosBodegaService;

import java.util.List;

@RestController
@RequestMapping("/employee/operariobodega")
public class OperariosBodegaController {
    @Autowired
    private OperariosBodegaService operariosBodegaService;

    @GetMapping
    public ResponseEntity<List<OperariosBodega>> getAllOperariosBodega() {
        return ResponseEntity.ok(operariosBodegaService.getAllOperariosBodega());
    }

    @PutMapping("/{id}")
    public ResponseEntity<OperariosBodega> updateOperariosBodega(@PathVariable Integer id, @RequestBody OperariosBodega operariosBodega) {
        if (operariosBodegaService.getOperariosBodegaById(id) != null) {
            operariosBodegaService.updateOperariosBodega(id, operariosBodega);
            return new ResponseEntity<>(operariosBodega, HttpStatus.OK);
        }
        return new ResponseEntity<>(operariosBodega, HttpStatus.NOT_FOUND);
    }


    @GetMapping("/{id}")
    public ResponseEntity<OperariosBodega> getOperariosBodegaById(@PathVariable Integer id) {
        OperariosBodega operariosBodega = operariosBodegaService.getOperariosBodegaById(id);
        if (operariosBodega != null) {
            return new ResponseEntity<>(operariosBodega, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OperariosBodega> deleteOperariosBodegaById(@PathVariable Integer id) {
        OperariosBodega operario = operariosBodegaService.getOperariosBodegaById(id);
        if (operario!= null) {
            operariosBodegaService.deleteOperariosBodega(id);
            return new ResponseEntity<>(operario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<OperariosBodega> createOperariosBodega(@RequestBody OperariosBodega operariosBodega) {
        operariosBodegaService.addOperariosBodega(operariosBodega);
        return new ResponseEntity<>(operariosBodega, HttpStatus.CREATED);
    }
}
