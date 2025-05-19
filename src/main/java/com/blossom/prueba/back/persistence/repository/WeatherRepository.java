package com.blossom.prueba.back.persistence.repository;

import com.blossom.prueba.back.persistence.entity.WeatherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WeatherRepository extends JpaRepository<WeatherEntity, Integer> {

    Optional<WeatherEntity> findByCity(String city);
}
