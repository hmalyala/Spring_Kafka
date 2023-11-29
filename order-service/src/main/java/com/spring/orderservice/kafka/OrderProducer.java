package com.spring.orderservice.kafka;

import com.spring.basedomains.dto.OrderEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderProducer {

    private KafkaTemplate<String, OrderEvent> kafkaTemplate;

    public OrderProducer(KafkaTemplate<String, OrderEvent> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    private NewTopic topic;

    public void sendMessage(OrderEvent orderEvent){

        Message<OrderEvent> message = MessageBuilder.withPayload(orderEvent).build();
        kafkaTemplate.send(message);
    }
}
