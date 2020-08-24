package com.controller;

import com.pojo.Order;
import com.service.OrderDownStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderRestController {
    @Autowired
    OrderDownStream orderDownStream;

    @PostMapping("/create")
    public Order createOrder(@RequestBody String json) {
        return orderDownStream.createOrder(json);
    }

    @PostMapping("/get/orders")
    public List<Order> getOrders() {
        return orderDownStream.getOrders();
    }
}
