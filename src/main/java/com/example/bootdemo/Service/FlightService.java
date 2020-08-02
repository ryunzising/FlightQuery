package com.example.bootdemo.Service;

import com.example.bootdemo.DAO.FlightMapper2;
import com.example.bootdemo.POJO.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {
    @Autowired
    FlightMapper2 fm;
    @Autowired
    RedisTemplate redisTemplate;
    public List<Flight> Sch(String Schedules){
        return fm.queryBySchedules(Schedules);
    }
    public List<Flight> Airlines(String Airlines){return fm.queryByAirlines(Airlines);}
    public List<Flight> deCity(String deCity){return fm.queryByDeCity(deCity);}
    public List<Flight> laCity(String laCity){return fm.queryByLaCity(laCity);}
    public int addFlight(String de_city, String la_city, String schedules, String airlines, String models, String de_airport, String la_airport){return fm.addFlightData(de_city,la_city,schedules,airlines,models,de_airport,la_airport);}
    public int deleteBysch(String sch){ return fm.deleteBySchedules(sch); }
    public List<Flight>queryAll(){return fm.queryAll();}
}
