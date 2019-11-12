package com.example.bootdemo.POJO;

import lombok.Data;

@Data
public class Flight {
    private String departure_city;
    private String landing_city;
    private String flight_schedules;
    private String airlines;
    private String aircraft_models;
    private String departure_airport;
    private String landing_airport;
}
