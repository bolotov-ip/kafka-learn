package com.kafka_test.rest_server.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka_test.rest_server.dto.MathVariablesDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MathServiceImpl implements MathService {

    private final KafkaTemplate<Long, MathVariablesDto> kafkaStarshipTemplate;
    private final ObjectMapper objectMapper;

    Logger logger = LoggerFactory.getLogger(MathServiceImpl.class);

    @Autowired
    public MathServiceImpl(KafkaTemplate<Long, MathVariablesDto> kafkaStarshipTemplate,
                           ObjectMapper objectMapper) {
        this.kafkaStarshipTemplate = kafkaStarshipTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public MathVariablesDto save(MathVariablesDto dto) {
        return null;
    }

    @Override
    public void send(MathVariablesDto dto) {
        logger.info("<= sending {}", writeValueAsString(dto));
        kafkaStarshipTemplate.send("server.starship", dto);
    }

    @Override
    @KafkaListener(id = "Starship", topics = {"server.starship"}, containerFactory = "singleFactory")
    public void consume(MathVariablesDto dto) {
        logger.info("=> consumed {}", writeValueAsString(dto));
    }

    private String writeValueAsString(MathVariablesDto dto) {
        try {
            return objectMapper.writeValueAsString(dto);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException("Writing value to JSON failed: " + dto.toString());
        }
    }
}