package com.spring.basedomains.dto;

import lombok.*;

import javax.annotation.processing.Generated;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {

    private UUID id;

    private String name;

    private int quantity;

    private int price;

}
