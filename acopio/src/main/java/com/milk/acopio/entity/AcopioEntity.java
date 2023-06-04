package com.milk.acopio.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "acopio")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class AcopioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private Date fecha;
    private String turno;
    private Long proveedorId;
    private Integer klsLeche;



}