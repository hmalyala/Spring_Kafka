package com.spring.stockservice.kafka.service;

import com.spring.basedomains.dto.Order;
import com.spring.basedomains.dto.OrderEvent;
import com.spring.stockservice.dto.Stock;
import com.spring.stockservice.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StockService {

    private final OrderRepository orderRepository;


    public StockService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    public void processOrder(OrderEvent orderEvent){

        Stock stock = new Stock();
        Order order = orderEvent.getOrder();
        stock.setId(order.getId());
        stock.setName(order.getName());
        stock.setPrice(order.getPrice());
        stock.setQuantity(order.getQuantity());

        orderRepository.save(stock);
        log.info("Stock item persisted to database");
    }
}
