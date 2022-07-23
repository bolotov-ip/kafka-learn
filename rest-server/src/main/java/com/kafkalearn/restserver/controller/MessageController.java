package com.kafkalearn.restserver.controller;

import com.kafkalearn.restserver.dto.MessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class MessageController {
    @Autowired
    private KafkaTemplate<String, MessageDto> kafkaTemplate;

    @RequestMapping("msg")
    public String sendOrder(@RequestBody MessageDto msg){
        String uniqueID = UUID.randomUUID().toString();
        kafkaTemplate.send("msg", uniqueID, msg);
        return "Working!";
    }
}
