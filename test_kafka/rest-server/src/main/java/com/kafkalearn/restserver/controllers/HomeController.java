package com.kafkalearn.restserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @RequestMapping(value = "/")
    public String helloWorldController(@RequestParam int x, @RequestParam int y) {
        kafkaTemplate.send("data_rest", "x: " + x + " ; " + "y: " + y);
        return "x: " + x + " ; " + "y: " + y;
    }
}
