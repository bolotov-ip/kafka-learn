package com.kafkalearn.mathserver.service;

import com.kafkalearn.mathserver.dto.AnswerDto;
import com.kafkalearn.mathserver.dto.MessageDto;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ArithmeticService {

    @Autowired
    private KafkaTemplate<String, AnswerDto> kafkaTemplate;

    Logger logger = LoggerFactory.getLogger(ArithmeticService.class);

    @KafkaListener(topics = {"msg"}, containerFactory = "kafkaListenerContainerFactory")
    public void msgListener(ConsumerRecord<String, MessageDto> record){
        MessageDto msg = record.value();
        AnswerDto ans = new AnswerDto(msg.getX() + msg.getY());
        kafkaTemplate.send("ans", record.key(), ans);
    }

}
