package com.blossom.prueba.back.service.impl;

import com.blossom.prueba.back.domain.WeatherDTO;
import com.blossom.prueba.back.persistence.entity.WeatherEntity;
import com.blossom.prueba.back.persistence.repository.WeatherRepository;
import com.blossom.prueba.back.service.AuditService;
import com.blossom.prueba.back.service.WeatherService;
import com.blossom.prueba.back.util.enums.StatusEnum;
import com.blossom.prueba.back.util.exceptions.NoDataFountException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class WeatherServiceImpl implements WeatherService {

    private static final String ONLY_LETTER_REGEX = "^[A-Za-zÀ-ÿ\\s]+$";

    private final WeatherRepository weatherRepository;
    private final AuditService auditService;

    public WeatherServiceImpl(WeatherRepository weatherRepository, AuditService auditService) {
        this.weatherRepository = weatherRepository;
        this.auditService = auditService;
    }

    @Override
    public WeatherDTO getWeatherIfo(String city) throws NoDataFountException, JsonProcessingException {

        if (!city.matches(ONLY_LETTER_REGEX)) {
            auditService.saveAudit(city, StatusEnum.FAIL.getDescription(), null, "The city is not valid.");
            throw new IllegalArgumentException("The city is not valid");
        }

        WeatherEntity entity = weatherRepository.findByCity(city).orElse(null);
        if (entity != null) {
            ObjectMapper mapper = new ObjectMapper();
            auditService.saveAudit(city, StatusEnum.SUCCESS.getDescription(), mapper.writeValueAsString(entity), null);
            return buildWeatherDto(entity);
        } else {
            auditService.saveAudit(city, StatusEnum.FAIL.getDescription(), null, "City not found in data base.");
            throw new NoDataFountException("City not found in data base.");
        }
    }

    private WeatherDTO buildWeatherDto(WeatherEntity entity) {

        WeatherDTO.Wind wind = new WeatherDTO.Wind();
        wind.setSpeed(entity.getWindSpeed());
        wind.setUnit(entity.getWindUnit());

        WeatherDTO.Temperature temp = new WeatherDTO.Temperature();
        temp.setValue(entity.getTemperatureValue());
        temp.setUnit(entity.getTemperatureUnit());

        return WeatherDTO.builder()
                .city(entity.getCity())
                .condition(entity.getCondition())
                .wind(wind)
                .temperature(temp)
                .build();
    }
}
