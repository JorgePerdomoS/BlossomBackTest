package com.blossom.prueba.back.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Data
@Table(name = "audit")
public class AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String city;
    @Column
    private Timestamp timestamp;
    @Column
    private String status;
    @Column
    private String source;
    @Column
    private String error;
}
