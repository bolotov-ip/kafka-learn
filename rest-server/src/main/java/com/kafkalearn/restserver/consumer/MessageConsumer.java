package com.kafkalearn.restserver.consumer;

import com.kafkalearn.restserver.dto.MessageDto;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {
    @KafkaListener(topics="msg")
    public void msgListener(ConsumerRecord<String, MessageDto> record){
        System.out.println(record.partition());
        System.out.println(record.key());
        if(record.value() instanceof MessageDto) {
            MessageDto dto = record.value();
            System.out.println(dto.getX() +":" + dto.getY());
        }
    }
}
