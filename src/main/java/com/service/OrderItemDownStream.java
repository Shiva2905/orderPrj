package com.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pojo.OrderItem;
import com.repository.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
@Service
public class OrderItemDownStream {
    @Autowired
    private OrderItemService orderItemService;

    public OrderItem createOrderItem(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            OrderItem orderItem = objectMapper.readValue(json, OrderItem.class);
            orderItemService.save(orderItem);
            return orderItem;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public List<OrderItem> getOrderItems() {
        return orderItemService.findAll();

    }
}
