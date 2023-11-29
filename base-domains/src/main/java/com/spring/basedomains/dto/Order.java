package com.spring.basedomains.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import javax.annotation.processing.Generated;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Order {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    private int quantity;

    private double price;

}
