package com.spring.orderservice.controller;

import com.spring.basedomains.dto.Order;
import com.spring.basedomains.dto.OrderEvent;
import com.spring.orderservice.kafka.OrderProducer;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class OrderController {

//    @Autowired
    private OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer){
        this.orderProducer = orderProducer;
    }

    @PostMapping("/order_created")
    public ResponseEntity<String> placeOrder(@RequestBody Order order){
        order.setId(UUID.randomUUID());
        OrderEvent orderEvent = new OrderEvent(order, "PENDING", "Order is in Pending status");
        orderProducer.sendMessage(orderEvent);
        return ResponseEntity.ok("Order Created Successfully");
    }
}
