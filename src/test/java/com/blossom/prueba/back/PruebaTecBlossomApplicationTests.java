package com.blossom.prueba.back;

import com.blossom.prueba.back.controller.WeatherController;
import com.blossom.prueba.back.domain.WeatherDTO;
import com.blossom.prueba.back.service.WeatherService;
import com.blossom.prueba.back.util.exceptions.NoDataFountException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@SpringBootTest
class PruebaTecBlossomApplicationTests {

    @Mock
    private WeatherService weatherService;

    @InjectMocks
    private WeatherController weatherController;

    private final String city = "Bogotá";
    private WeatherDTO sampleDto;

    @BeforeEach
    void setUp() {
        sampleDto = WeatherDTO.builder()
                .city(city)
                .condition("Soleado")
                .wind(new WeatherDTO.Wind())
                .temperature(new WeatherDTO.Temperature())
                .build();
    }

    @Test
    void whenServiceReturnsData_thenResponseIsOk() throws Exception {
        // Arrange
        when(weatherService.getWeatherIfo(city)).thenReturn(sampleDto);

        // Act
        ResponseEntity<WeatherDTO> response = weatherController.getCityInformation(city);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(sampleDto, response.getBody());
        verify(weatherService, times(1)).getWeatherIfo(city);
    }

    @Test
    void whenNoDataFound_thenResponseIsNoContent() throws Exception {
        // Arrange
        when(weatherService.getWeatherIfo(city)).thenThrow(new NoDataFountException("No data for city"));

        // Act
        ResponseEntity<WeatherDTO> response = weatherController.getCityInformation(city);

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertNull(response.getBody());
        verify(weatherService, times(1)).getWeatherIfo(city);
    }

}
