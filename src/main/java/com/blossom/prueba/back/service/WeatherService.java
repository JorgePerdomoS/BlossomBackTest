package com.blossom.prueba.back.service;

import com.blossom.prueba.back.domain.WeatherDTO;
import com.blossom.prueba.back.util.exceptions.NoDataFountException;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

@Service
public interface WeatherService {

    WeatherDTO getWeatherIfo(String city) throws NoDataFountException, JsonProcessingException;
}
