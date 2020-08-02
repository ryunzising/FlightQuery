package com.example.bootdemo.controller;

import com.example.bootdemo.POJO.Flight;
import com.example.bootdemo.Service.FlightService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping(value = "/Flight",method = RequestMethod.GET)//根据航班号查询
    public List<Flight> getFlightInfoBySchedules(@RequestParam String schedules){
        return fs.Sch(schedules);
    }
    @ResponseBody
    @RequestMapping(value = "/Airlines",method = RequestMethod.GET)
    public List<Flight> getFlightInfoByAirlines(@RequestParam String airlines){
        return fs.Airlines(airlines);
    }
    @ResponseBody
    @RequestMapping(value = "/Departure",method = RequestMethod.GET)
    public List<Flight> getFlightInfoBydeCity(@RequestParam String deCity){
        return fs.deCity(deCity);
    }
    @ResponseBody
    @RequestMapping(value = "/Landing",method = RequestMethod.GET)
    public List<Flight> getFlightInfoBylaCity(@RequestParam String laCity){
        return fs.laCity(laCity);
    }
    @RequestMapping(value = "/insertData",method = RequestMethod.POST)//增加
    public String addFlightData(@RequestParam(value = "deCity")String deCity, @RequestParam(value = "laCity")String laCity, @RequestParam(value = "schedules")String schedules
            , @RequestParam(value = "airlines")String airlines, @RequestParam(value = "models")String models, @RequestParam(value = "deAirport")String deAirport, @RequestParam(value = "laAirport")String laAirport){
        int result=fs.addFlight(deCity,laCity,schedules,airlines,models,deAirport,laAirport);
        if (result==1) return "success";
        else return "fail";
    }
    @RequestMapping(value = "/deleteBySch/{Sch}",method = RequestMethod.DELETE)//根据航班号删除
    public String deleteBySch(@PathVariable String Sch){
        int result=fs.deleteBysch(Sch);
        if (result!=0) return "success";
        else return "fail";
    }
    @ResponseBody
    @RequestMapping(value = "/queryAll",method = RequestMethod.GET)
    public PageInfo<Flight> queryALl(@RequestParam(defaultValue = "1",value = "pageNum")Integer pageNum){
        PageHelper.startPage(pageNum,3);
        List<Flight> result=fs.queryAll();
        PageInfo<Flight> pageInfo= new PageInfo<>(result);
        return pageInfo;
    }
    @ResponseBody
    @RequestMapping(value = "/AirlinesPage/{airlines}",method = RequestMethod.GET)
    public PageInfo<Flight> getFlightInfoByAirlinesPage(@PathVariable String airlines,@RequestParam(defaultValue = "1",value = "pageNum")Integer pageNum){
        PageHelper.startPage(pageNum,5);
        List<Flight> result=fs.Airlines(airlines);
        PageInfo<Flight> pageInfo= new PageInfo<>(result);
        return pageInfo;
    }
    }
