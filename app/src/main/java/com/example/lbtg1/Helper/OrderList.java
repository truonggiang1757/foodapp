package com.example.lbtg1.Helper;

import android.content.Context;

import com.example.lbtg1.Domain.Order;

import java.util.ArrayList;

public class OrderList {
    private Context context;
    private TinyDB tinyDB;
    ArrayList<Order> orderList;

    public OrderList(Context context) {
        this.context = context;
        this.tinyDB = new TinyDB(context);
    }

    public void insertOrder(Order item) {
        orderList = getOrderList();
        int index = 0;
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).getOrderTitle().equals(item.getOrderTitle())) {
                index = i;
                break;
            }
        }
//        item.setOrderId(1);
//        item.setAddress("12 Hoang Minh Giam");
//        item.setOrderTitle("23/04/2024 - 17:56:23");
//        item.setDescription("2 Pizza + 3 Chicken");
//        item.setStatus("Delivering");
//        item.setTotalPrice(2000000.0);
//        orderList.add(item);
//        tinyDB.putListObject("OrderList", orderList);
    }

    public ArrayList<Order> getOrderList() {
//        return orderList;
        return null;
    }

//    public Double getTotalCost() {
//        ArrayList<Order> orderList = getOrderList();
//        double totalCost = 0;
//        for (Foods item : orderList) {
//           totalCost += item.getPrice() * item.getQuantity();
//        }
//        return totalCost;
//    }

}
