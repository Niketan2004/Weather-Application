package com.project.Weather_Application.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherModel {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Clouds {
        private int all;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Main {
        private double temp;
        private double feels_like;
        private double temp_min;
        private double temp_max;
        private int pressure;
        private int humidity;

    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Sys {
        private String country;
        private int sunrise;
        private int sunset;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Weather {

        private String main;
        private String description;
        private String icon;

    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Wind {
        private double speed;

    }

    private Clouds clouds;
    private Main main;
    private Sys sys;
    private List<Weather> weather;
    private Wind wind;
    private String name;

}