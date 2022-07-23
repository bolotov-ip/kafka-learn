package com.kafkalearn.restserver.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {
    @KafkaListener(topics="msg")
    public void msgListener(String msg){
        System.out.println(msg);
    }
}
