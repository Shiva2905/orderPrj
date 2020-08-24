package com.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pojo.Order;
import com.repository.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
@Service
public class OrderDownStream {
    @Autowired
    private OrderService orderService;

    public Order createOrder(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Order order = objectMapper.readValue(json, Order.class);
            orderService.save(order);
            return order;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public List<Order> getOrders() {
        return orderService.findAll();

    }
}
