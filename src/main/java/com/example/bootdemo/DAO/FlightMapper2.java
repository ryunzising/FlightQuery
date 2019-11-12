package com.example.bootdemo.DAO;

import com.example.bootdemo.POJO.Flight;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository

public interface FlightMapper2 {
    @Select("SELECT * FROM flight WHERE flight.flight_schedules = #{sch}")
    List<Flight> queryBySchedules(String sch);
    @Select("SELECT * FROM flight WHERE flight.airlines = #{airlines}")
    List<Flight>queryByAirlines(String airline);
    @Select("SELECT * FROM flight WHERE flight.departure_city=#{deCity}")
    List<Flight> queryByDeCity(String City);
    @Select("SELECT * FROM flight WHERE flight.departure_city=#{laCity}")
    List<Flight> queryByLaCity(String City);

}
