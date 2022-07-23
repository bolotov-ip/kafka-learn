package com.kafka_test.rest_server.service;

import com.kafka_test.rest_server.dto.MathVariablesDto;

public interface MathService {

    MathVariablesDto save(MathVariablesDto dto);

    void send(MathVariablesDto dto);

    void consume(MathVariablesDto dto);
}
