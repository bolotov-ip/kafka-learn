package com.kafkalearn.logserver.service;

import com.kafkalearn.logserver.dto.AnswerDto;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class LogAnswerService {

    Logger logger = LoggerFactory.getLogger(LogAnswerService.class);

    @KafkaListener(topics = {"ans"}, containerFactory = "kafkaListenerContainerFactory")
    public void msgListener(ConsumerRecord<String, AnswerDto> record){
        AnswerDto msg = record.value();

        String message = new StringBuilder(record.key()).append(" - ").append(msg.getSum()).append("\n").toString();

        Path path = Paths.get("./logs");
        File answerLog = new File(path.toString(), "answer.log");
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(answerLog, true)))
        {
            bw.write(message);
        }
        catch(IOException e){
            logger.error(e.getMessage());
        }
    }

}
