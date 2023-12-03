package com.spring.stockservice.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class StockServiceApplication {

    @KafkaListener()
    public void listenMessage(){

    }

}
