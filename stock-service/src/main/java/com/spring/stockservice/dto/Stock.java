package com.spring.stockservice.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Stock {

    @Id
    UUID id;

    String name;

    int quantity;

    double price;
}
