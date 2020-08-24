package com.pojo;

import java.util.Date;
import java.util.List;

public class Order {
    private String customerName;
    private Date orderDate;
    private String shippingAddress;
    private List<OrderItem> orderItems;
    private int totalAmt;

    public Order() {
    }

    public String getCustomerName() {
        return customerName;
    }

    public Order setCustomerName(String customerName) {
        this.customerName = customerName;
        return this;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public Order setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public Order setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
        return this;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public Order setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
        return this;
    }

    public int getTotalAmt() {
        return totalAmt;
    }

    public Order setTotalAmt(int totalAmt) {
        this.totalAmt = totalAmt;
        return this;
    }
}
