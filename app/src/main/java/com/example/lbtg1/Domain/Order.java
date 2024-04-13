package com.example.lbtg1.Domain;

import java.io.Serializable;

public class Order implements Serializable {
    private int OrderId;
    private String OrderTitle;
    private String Description;
    private String Address;
    private double totalPrice;
    private String Status;

    public int getOrderId() {
        return OrderId;
    }

    public void setOrderId(int orderId) {
        OrderId = orderId;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }


    public String getOrderTitle() {
        return OrderTitle;
    }

    public void setOrderTitle(String orderTitle) {
        OrderTitle = orderTitle;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
