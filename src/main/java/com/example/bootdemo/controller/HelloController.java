package com.example.bootdemo.controller;

import com.example.bootdemo.POJO.Flight;
import com.example.bootdemo.Service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HelloController {
    @Autowired
    private FlightService fs;
    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello World";
    }
    @ResponseBody
    @RequestMapping(value = "/Flight/{schedules}",method = RequestMethod.GET)
    public List<Flight> getFlightInfoBySchedules(@PathVariable String schedules){
        return fs.Sch(schedules);
    }
    @ResponseBody
    @RequestMapping(value = "/Airlines/{airlines}",method = RequestMethod.GET)
    public List<Flight> getFlightInfoByAirlines(@PathVariable String airlines){
        return fs.Airlines(airlines);
    }
    @ResponseBody
    @RequestMapping(value = "/Departure/{deCity}",method = RequestMethod.GET)
    public List<Flight> getFlightInfoBydeCity(@PathVariable String deCity){
        return fs.deCity(deCity);
    }
    @ResponseBody
    @RequestMapping(value = "/Landing/{laCity}",method = RequestMethod.GET)
    public List<Flight> getFlightInfoBylaCity(@PathVariable String laCity){
        return fs.laCity(laCity);
    }
    }
