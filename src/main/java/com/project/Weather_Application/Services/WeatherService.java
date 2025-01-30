package com.project.Weather_Application.Services;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

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

                    // mapps the JSON format to Java(POJO) and stores it in WeatherModel class
                    WeatherModel weatherModel = objectMapper.readValue(weather.getBody(), WeatherModel.class);
                    // 1. Convert Kelvin to Celsius
                    convertKelvinToCelsius(weatherModel);

                    // 2. Convert Unix timestamps to IST
                    convertUnixTimestampsToIST(weatherModel);
                    System.out.println(weatherModel.toString());
                    return weatherModel;
               } catch (Exception e) {
                    // if there is an error while mapping the data then it will throw the new error
                    throw new RuntimeJsonMappingException("Failed to Mapped Data");

               }

          } else {
               // throws an error when city not found
               System.out.println(weather.getStatusCode());
               throw new RuntimeException(weather.getStatusCode() + "City not Found");
          }

     }


     //converting temperature from kelvin to degree celcius
     private void convertKelvinToCelsius(WeatherModel weatherModel) {
          if (weatherModel != null && weatherModel.getMain() != null) {
               double tempKelvin = weatherModel.getMain().getTemp();
               int tempCelsius = (int) (tempKelvin - 273.15);
               weatherModel.getMain().setTemp(tempCelsius);

               double feelsLikeKelvin = weatherModel.getMain().getFeels_like();
               int feelsLikeCelsius = (int) (feelsLikeKelvin - 273.15);
               weatherModel.getMain().setFeels_like(feelsLikeCelsius);

               double tempMinKelvin = weatherModel.getMain().getTemp_min();
               int tempMinCelsius = (int) (tempMinKelvin - 273.15);
               weatherModel.getMain().setTemp_min(tempMinCelsius);

               double tempMaxKelvin = weatherModel.getMain().getTemp_max();
               int tempMaxCelsius = (int) (tempMaxKelvin - 273.15);
               weatherModel.getMain().setTemp_max(tempMaxCelsius);
          }
     }


     //converting time from UTC to IST
     private void convertUnixTimestampsToIST(WeatherModel weatherModel) {
          if (weatherModel != null && weatherModel.getSys() != null) {
               try {
                    String sunriseStr = weatherModel.getSys().getSunrise();
                    String sunsetStr = weatherModel.getSys().getSunset();

                    // Check for null or empty strings to avoid parsing errors
                    if (sunriseStr != null && !sunriseStr.isEmpty() && sunsetStr != null && !sunsetStr.isEmpty()) {
                         long sunriseUnix = Long.parseLong(sunriseStr); // Parse the string to long
                         long sunsetUnix = Long.parseLong(sunsetStr); // Parse the string to long

                         // formats the converted IST to proper IST format
                         String sunriseIST = formatUnixTimestampToIST(sunriseUnix);
                         String sunsetIST = formatUnixTimestampToIST(sunsetUnix);

                         weatherModel.getSys().setSunrise(sunriseIST);
                         weatherModel.getSys().setSunset(sunsetIST);
                    } else {
                         // Handle the case where sunrise or sunset strings are null or empty
                         weatherModel.getSys().setSunrise("N/A"); // Or some other default value
                         weatherModel.getSys().setSunset("N/A");
                    }
               } catch (NumberFormatException e) {
                    // Handle the case where the strings are not valid numbers
                    weatherModel.getSys().setSunrise("Invalid Timestamp");
                    weatherModel.getSys().setSunset("Invalid Timestamp");
                    // You might want to log this error for debugging:
                    System.err.println("Error parsing timestamps: " + e.getMessage());
               }
          }
     }

     //formats the timestamp of above converted format  into  IST format 
     private String formatUnixTimestampToIST(long unixTimestamp) {
          Instant instant = Instant.ofEpochSecond(unixTimestamp);
          LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.of("Asia/Kolkata")); // IST
          DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss"); // Customize format
          return localDateTime.format(formatter);
     }

}
