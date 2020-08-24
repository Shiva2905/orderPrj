package com.pojo;

public class OrderItem {
    private String productCode;
    private String productName;
    private int qty;

    public OrderItem() {
    }

    public int getQty() {
        return qty;
    }

    public OrderItem setQty(int qty) {
        this.qty = qty;
        return this;
    }

    public String getProductName() {
        return productName;
    }

    public OrderItem setProductName(String productName) {
        this.productName = productName;
        return this;
    }

    public String getProductCode() {
        return productCode;
    }

    public OrderItem setProductCode(String productCode) {
        this.productCode = productCode;
        return this;
    }
}
