package com.milk.acopio.controller;

import com.milk.acopio.Service.AcopioService;
import com.milk.acopio.entity.AcopioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acopio")

public class AcopioController {
    @Autowired
    AcopioService acopioService;

    @GetMapping
    public ResponseEntity<List<AcopioEntity>> getAll() {
        List<AcopioEntity> acopios = acopioService.getAll();
        if (acopios.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(acopios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AcopioEntity> getByid(@PathVariable("id") long id) {
        AcopioEntity acopio = acopioService.getAcopiobyid(id);
        if (acopio == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(acopio);
    }

    @PostMapping()
    public ResponseEntity<AcopioEntity> save(@RequestBody AcopioEntity acopio) {
        AcopioEntity acopioNew = acopioService.save(acopio);
        return ResponseEntity.ok(acopioNew);
    }

    @GetMapping("/byproveedor/{proveedorId}")
    public ResponseEntity<List<AcopioEntity>> getByProveedorId(@PathVariable("proveedorId")long proveedorId){
        List<AcopioEntity> acopios = acopioService.byProveedorId(proveedorId);
        if (acopios.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(acopios);
    }
}


