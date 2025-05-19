package com.blossom.prueba.back.controller;

import com.blossom.prueba.back.domain.WeatherDTO;
import com.blossom.prueba.back.service.WeatherService;
import com.blossom.prueba.back.util.exceptions.NoDataFountException;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weather")
@Slf4j
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @Operation(summary = "Obtains weather information for a city")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Information found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = WeatherDTO.class))),
            @ApiResponse(responseCode = "204", description = "No information found for the city"),
            @ApiResponse(responseCode = "400", description = "City name is not valid"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/{city}")
    public ResponseEntity<WeatherDTO> getCityInformation(
            @Parameter(description = "City name", required = true)
            @PathVariable String city) {
        try {
            log.info("Execute getCityInformation for city: {}", city);
            WeatherDTO response = weatherService.getWeatherIfo(city);
            return ResponseEntity.ok(response);
        } catch (NoDataFountException e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (IllegalArgumentException e) {
            log.warn("City name {} is not valid", city);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
