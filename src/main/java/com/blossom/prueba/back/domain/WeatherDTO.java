package com.blossom.prueba.back.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WeatherDTO {

    private String city;
    private Temperature temperature;
    private String condition;
    private Wind wind;

    @Data
    public static class Temperature {
        private double value;
        private String unit;
    }

    @Data
    public static class Wind {
        private double speed;
        private String unit;
    }

}





