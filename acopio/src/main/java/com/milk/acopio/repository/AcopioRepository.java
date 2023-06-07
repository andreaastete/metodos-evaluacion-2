package com.milk.acopio.repository;

import com.milk.acopio.entity.AcopioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcopioRepository extends JpaRepository<AcopioEntity, Long> {

    List<AcopioEntity> findByProveedorId(long proveedorId);

}

