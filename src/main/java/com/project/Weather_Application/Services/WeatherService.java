package com.project.Weather_Application.Services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.RuntimeJsonMappingException;
import com.project.Weather_Application.Model.WeatherModel;

@Service
public class WeatherService {
     // Gets api key from the application.properties
     @Value("${API_KEY}")
     private String key;

     // method to find temperature
     public WeatherModel getWeatherData(String city) {

          // final url to hit with city name and apiKey
          final String api_key = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + key;
          // RestTemplate to hit the url
          RestTemplate restTemplate = new RestTemplate();
          // getting the response of the Weather data in the form of string
          ResponseEntity<String> weather = restTemplate.getForEntity(api_key, String.class);
          if (weather.getStatusCode() == HttpStatus.OK) {
               try {
                    // mapping the String/JSON data to the Java WeatherModel class
                    ObjectMapper objectMapper = new ObjectMapper();
                   
                    WeatherModel weatherModel = objectMapper.readValue(weather.getBody(), WeatherModel.class);
                    System.out.println(weatherModel.toString());
                    return weatherModel;
               } catch (Exception e) {
                    // if there is an error while mapping the data then it will throw the new error
                    throw new RuntimeJsonMappingException("Failed to Mapped Data");

               }

          } else {
               // throws an error when city not found
               System.out.println(weather.getStatusCode());
               throw new RuntimeException(weather.getStatusCode()+"City not Found");
          }

     }

}
