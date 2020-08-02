package com.example.bootdemo.DAO;

import com.example.bootdemo.POJO.Flight;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Indexed;
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
    @Select("SELECT * FROM flight WHERE flight.landing_city=#{laCity}")
    List<Flight> queryByLaCity(String City);
    @Insert("INSERT INTO flight VALUES(#{deCity},#{laCity},#{schedules},#{airlines},#{models},#{de_airport},#{la_airport}")
    int addFlightData(String de_city, String la_city, String schedules, String airlines, String models, String de_airport, String la_airport);
    @Delete("DELETE FROM flight WHERE flight_schedules= #{schedules}")
    int deleteBySchedules(String sch);
    @Select("SELECT * FROM flight")
    List<Flight>queryAll();

}
