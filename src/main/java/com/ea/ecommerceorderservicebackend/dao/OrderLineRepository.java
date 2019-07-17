package com.ea.ecommerceorderservicebackend.dao;

import com.ea.ecommerceorderservicebackend.model.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {
}
