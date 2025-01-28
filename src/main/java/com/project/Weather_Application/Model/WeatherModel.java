package com.project.Weather_Application.Model;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class WeatherModel {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Clouds {
        private int all;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Main {
        private double temp;
        private double feels_like;
        private double temp_min;
        private double temp_max;
        private int pressure;
        private int humidity;
        private int sea_level;
        private int grnd_level;
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
    public class Weather {
        private int id;
        private String main;
        private String description;
        private String icon;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Wind {
        private double speed;
        private int deg;
        private double gust;
    }

}
