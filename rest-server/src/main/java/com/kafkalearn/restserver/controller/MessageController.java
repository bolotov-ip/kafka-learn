package com.kafkalearn.restserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @RequestMapping("msg")
    public String sendOrder(String msgId, String msg){
        kafkaTemplate.send("msg", msgId, msg);
        return "Working!";
    }
}
