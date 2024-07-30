package com.example.demo;

import org.springframework.web.bind.annotation.RestController;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
public class ControllerDemo {
    @Autowired
    private DemoService demoService;

    @GetMapping("/demo")
    public String Demo(){
        return "Hello, welocme to a Spring boot demo page. This is a GET request.";
    }
    @GetMapping("/demo/topics")
    public List<DemoReturnAJSONObj> DemoJSON(){
        return demoService.getAllObjects();
    }
    @GetMapping("/demo/topics/{id}")
    public DemoReturnAJSONObj getMethod(@PathVariable int id) {
        return demoService.getObj(id);
    }
    @PostMapping("/demo/topics")
    public String postMethod(@RequestBody DemoReturnAJSONObj body) {
        try {
        demoService.addObj(body);
        return "Response: 200 OK";
        } catch (Exception e) {
            return "Response: 500 Internal Server Error";
        }
    
    }
    @PutMapping("/demo/topics/{id}")
    public String UpdateMethod(@PathVariable int id, @RequestBody DemoReturnAJSONObj body) {
        try {
        demoService.updateObj(id, body);
        return "Response: 200 OK";
        } catch (Exception e) {
            return "Response: 500 Internal Server Error";
        }
    
    }
    @DeleteMapping("/demo/topics/{id}")
    public String DeleteMethod(@PathVariable int id) {
        try {
        demoService.deleteObj(id);
        return "Response: 200 OK";
        } catch (Exception e) {
            return "Response: 500 Internal Server Error";
        }
    }

    @PatchMapping("/demo/topics/{id}")
    public String PatchMethod(@PathVariable int id, @RequestBody DemoReturnAJSONObj body) {
        try {
        demoService.partialUpdateObj(id, body);
        return "Response: 200 OK";
        } catch (Exception e) {
            return "Response: 500 Internal Server Error";
        }
    }

    
    
}
