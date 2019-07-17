package com.ea.ecommerceorderservicebackend.dao;

import com.ea.ecommerceorderservicebackend.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
