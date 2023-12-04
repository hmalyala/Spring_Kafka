package com.spring.stockservice.kafka;

import com.spring.basedomains.dto.OrderEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderConsumer {

    @KafkaListener(topics = "${spring.kafka.topic.name}",
                        groupId = "${spring.kafka.consumer.group-id}")
    public void listenMessage(OrderEvent orderEvent){
        log.info(String.format("Order Event received in Stock service => %s", orderEvent.toString()));
    }

}