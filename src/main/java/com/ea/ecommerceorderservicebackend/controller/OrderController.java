package com.ea.ecommerceorderservicebackend.controller;

import com.ea.ecommerceorderservicebackend.model.Cart;
import com.ea.ecommerceorderservicebackend.model.Order;
import com.ea.ecommerceorderservicebackend.model.OrderLine;
import com.ea.ecommerceorderservicebackend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/order/")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OrderService orderService;

    private String cart_service_url = "http://cart-service:8083/rest/cart";

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id){
        return orderService.getOrder(id);
    }

    @PostMapping("/create/{accountId}/{cartId}/{tax}/{shippingId}")
    public Order createOrder(@PathVariable Long accountId, @PathVariable Long cartId, @PathVariable Double tax, @PathVariable Long shippingId){
        // Todo call the cart service and get a cart with an an ID - cartId, then add the orderLines in there to the order's orderLine

        Cart cart = restTemplate.getForObject(cart_service_url + "/" + cartId, Cart.class);

        Order order = new Order();
        order.setOrderDate(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
        order.setShippingId(shippingId);
        order.setAccountId(accountId);
        order.setTax(tax);

        List<OrderLine> orderLineList = cart.getOrderLineIdList()
                .stream()
                .map(aLong -> orderService.getOrderLine(aLong))
                .collect(Collectors.toList());

        for (OrderLine orderLine:
             orderLineList) {
            order.addOrderLine(orderLine);
        }

        return orderService.createOrder(order);
    }

    @PostMapping("/orderLine/create/{productId}/{quantity}")
    public OrderLine createOrderLine(@PathVariable Long productId, @PathVariable Integer quantity){
        OrderLine orderLine = new OrderLine();
        orderLine.setProductId(productId);
        orderLine.setQuantity(quantity);

        return orderService.createOrderLine(orderLine);
    }
    @PostMapping("addOrder")
    public Order addOrder(@RequestBody Order order){
        return orderService.addOrder(order);
    }
    @GetMapping("getOrders/{id}")
    public List<Order> getAllOrdersByAccount(@PathVariable Long id) {
        return orderService.findAllByAccountId(id);
    }
}
