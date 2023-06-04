package com.milk.proveedor.Service;

import com.milk.proveedor.entity.ProveedorEntity;
import com.milk.proveedor.model.Acopio;
import com.milk.proveedor.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class ProveedorService {
        @Autowired
        ProveedorRepository proveedorRepository;
        @Autowired
        RestTemplate restTemplate;
        public List<ProveedorEntity> getAll() {
            return proveedorRepository.findAll();
        }


    public ProveedorEntity getProveedorbyid(long id) {
        return proveedorRepository.findById(id).orElse(null);
    }

    public ProveedorEntity save(ProveedorEntity proveedor){
        ProveedorEntity proveedorNew = proveedorRepository.save(proveedor);
        return proveedorNew;
    }

    public List<Acopio> getAcopios(long proveedorid) {
        List<Acopio> acopios = restTemplate.getForObject("http://localhost:8002/acopio/byproveedor/" + proveedorid, List.class);
        return acopios;
        }

}
