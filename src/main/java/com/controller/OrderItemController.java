package com.controller;

import com.pojo.OrderItem;
import com.service.OrderItemDownStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderItemController {
    @Autowired
    private OrderItemDownStream orderItemDownStream;

    @PostMapping("/create")
    public OrderItem createOrderItem(@RequestBody String json) {
        return orderItemDownStream.createOrderItem(json);
    }

    @PostMapping("/get/orderItems")
    public List<OrderItem> getOrderItems() {
        return orderItemDownStream.getOrderItems();
    }
}
