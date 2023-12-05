package com.spring.stockservice.kafka;

import com.spring.basedomains.dto.OrderEvent;
import com.spring.stockservice.kafka.service.StockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderConsumer {

    public StockService stockService;

    public OrderConsumer(StockService stockService){
        this.stockService = stockService;
    }
    @KafkaListener(topics = "${spring.kafka.topic.name}",
                        groupId = "${spring.kafka.consumer.group-id}")
    public void listenMessage(OrderEvent orderEvent){
        log.info(String.format("Order Event received in Stock service => %s", orderEvent.toString()));
        stockService.processOrder(orderEvent);
    }

}