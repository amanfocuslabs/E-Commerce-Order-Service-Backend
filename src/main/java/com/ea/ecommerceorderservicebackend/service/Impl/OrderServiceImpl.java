package com.ea.ecommerceorderservicebackend.service.Impl;

import com.ea.ecommerceorderservicebackend.dao.OrderLineRepository;
import com.ea.ecommerceorderservicebackend.dao.OrderRepository;
import com.ea.ecommerceorderservicebackend.model.Order;
import com.ea.ecommerceorderservicebackend.model.OrderLine;
import com.ea.ecommerceorderservicebackend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderLineRepository orderLineRepository;

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order getOrder(Long id) {
        return orderRepository.getOne(id);
    }

    @Override
    public OrderLine createOrderLine(OrderLine orderLine) {
        return orderLineRepository.save(orderLine);
    }

    @Override
    public OrderLine getOrderLine(Long id) {
        return orderLineRepository.getOne(id);
    }

    @Override
    public List<Order> findAllByAccountId(Long id) {
        return orderRepository.findAllByAccountId(id);
    }

    @Override
    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }
}
