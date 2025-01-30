package com.project.Weather_Application.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.Weather_Application.Model.WeatherModel;
import com.project.Weather_Application.Services.WeatherService;

@Controller
public class WeatherController {
     @Autowired
     private WeatherService weatherService;

     @GetMapping("/")
     public String home() {
          return "index";
     }

     @GetMapping("/weather")
     public String getWeather(@RequestParam("city") String location, Model model) {
          System.out.println("city is " + location);
          try {
               WeatherModel weatherData = weatherService.getWeatherData(location);
               model.addAttribute("weatherData", weatherData);
               return "weather"; // Your weather details page template
          } catch (Exception e) {
               System.out.println( e.getMessage());
               model.addAttribute("errorMessage", "City not found.");
               return "index"; // Redirect back to the landing page with the error message
          }
     }
}