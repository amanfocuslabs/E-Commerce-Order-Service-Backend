package com.ea.ecommerceorderservicebackend.service;

import com.ea.ecommerceorderservicebackend.model.Order;
import com.ea.ecommerceorderservicebackend.model.OrderLine;

import java.util.List;

public interface OrderService {
    Order createOrder(Order order);
    Order getOrder(Long id);
    OrderLine createOrderLine(OrderLine orderLine);
    OrderLine getOrderLine(Long id);
    List<Order> findAllByAccountId(Long id);
    Order addOrder(Order order);
}
