package com.ea.ecommerceorderservicebackend.service;

import com.ea.ecommerceorderservicebackend.model.Order;
import com.ea.ecommerceorderservicebackend.model.OrderLine;

public interface OrderService {
    Order createOrder(Order order);
    Order getOrder(Long id);
    OrderLine createOrderLine(OrderLine orderLine);
    OrderLine getOrderLine(Long id);
}
