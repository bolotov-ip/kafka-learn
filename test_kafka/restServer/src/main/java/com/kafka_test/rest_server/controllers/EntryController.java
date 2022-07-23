package com.kafka_test.rest_server.controllers;

import com.kafka_test.rest_server.dto.MathVariablesDto;
import com.kafka_test.rest_server.service.MathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class EntryController {
    private final MathService service;

    @Autowired
    public EntryController(MathService service) {
        this.service = service;
    }

    @PostMapping
    public String home(@RequestBody MathVariablesDto dto) {
        service.send(dto);
        return "Spring Boot!";
    }
}
