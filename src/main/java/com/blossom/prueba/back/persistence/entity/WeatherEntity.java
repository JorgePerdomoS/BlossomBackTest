package com.blossom.prueba.back.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "weather")
public class WeatherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String city;
    @Column(name = "temperature_value")
    private double temperatureValue;
    @Column(name = "temperature_unit")
    private String temperatureUnit;
    @Column
    private String condition;
    @Column(name = "wind_speed")
    private double windSpeed;
    @Column(name = "wind_unit")
    private String windUnit;
}
