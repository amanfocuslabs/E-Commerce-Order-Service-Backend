package com.ea.ecommerceorderservicebackend.dao;

import com.ea.ecommerceorderservicebackend.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    public List<Order> findAllByAccountId(Long id);
}
