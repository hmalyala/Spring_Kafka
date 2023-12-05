package com.spring.stockservice.repository;

import com.spring.stockservice.dto.Stock;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface OrderRepository extends CrudRepository<Stock, UUID> {

}
