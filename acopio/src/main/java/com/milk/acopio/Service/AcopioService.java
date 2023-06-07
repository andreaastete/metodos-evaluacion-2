package com.milk.acopio.Service;

import com.milk.acopio.entity.AcopioEntity;
import com.milk.acopio.repository.AcopioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class AcopioService {
    @Autowired
    AcopioRepository acopioRepository;
    public List<AcopioEntity> getAll() {
        return acopioRepository.findAll();
    }


    public AcopioEntity getAcopiobyid(long id) {
        return acopioRepository.findById(id).orElse(null);
    }

    public AcopioEntity save(AcopioEntity acopio){
        AcopioEntity acopioNew = acopioRepository.save(acopio);
        return acopioNew;
    }

    public List<AcopioEntity> byProveedorId(long proveedorId){
        return acopioRepository.findByProveedorId(proveedorId);

    }

}
