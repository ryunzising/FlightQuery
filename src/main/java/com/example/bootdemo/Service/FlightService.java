package com.example.bootdemo.Service;

import com.example.bootdemo.DAO.FlightMapper2;
import com.example.bootdemo.POJO.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {
    @Autowired
    FlightMapper2 fm;
    public List<Flight> Sch(String Schedules){
        return fm.queryBySchedules(Schedules);
    }
    public List<Flight> Airlines(String Airlines){return fm.queryByAirlines(Airlines);}
    public List<Flight> deCity(String deCity){return fm.queryByDeCity(deCity);}
    public List<Flight> laCity(String laCity){return fm.queryByLaCity(laCity);}
}
