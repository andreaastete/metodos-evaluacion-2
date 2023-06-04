package com.milk.proveedor.controller;

import com.milk.proveedor.Service.ProveedorService;
import com.milk.proveedor.entity.ProveedorEntity;
import com.milk.proveedor.model.Acopio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proveedor")

public class ProveedorController {
    @Autowired
    ProveedorService proveedorService;
    @GetMapping
    public ResponseEntity<List<ProveedorEntity>> getAll(){
        List<ProveedorEntity> proveedores = proveedorService.getAll();
        if (proveedores.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(proveedores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProveedorEntity> getByid(@PathVariable("id")long id){
        ProveedorEntity proveedor = proveedorService.getProveedorbyid(id);
        if (proveedor== null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(proveedor);
    }

    @PostMapping()
    public ResponseEntity<ProveedorEntity> save(@RequestBody ProveedorEntity proveedor){
        ProveedorEntity proveedorNew = proveedorService.save(proveedor);
        return ResponseEntity.ok(proveedorNew);
    }
    @GetMapping("/acopios/{proveedorId}")
    public ResponseEntity<List<Acopio>> getAcopios (@PathVariable("proveedorId")long proveedorId){
        ProveedorEntity proveedor = proveedorService.getProveedorbyid(proveedorId);
        if (proveedor == null)
            return ResponseEntity.notFound().build();
        List<Acopio> acopios = proveedorService.getAcopios(proveedorId);
        return ResponseEntity.ok(acopios);
    }
}
