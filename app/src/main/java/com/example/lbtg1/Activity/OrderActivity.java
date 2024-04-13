package com.example.lbtg1.Activity;

import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lbtg1.Adapter.OrderAdapter;
import com.example.lbtg1.Domain.Foods;
import com.example.lbtg1.Domain.Order;
import com.example.lbtg1.Helper.ManagmentCart;
import com.example.lbtg1.Helper.OrderList;
import com.example.lbtg1.databinding.ActivityOrderBinding;

import java.util.ArrayList;

public class OrderActivity extends BaseActivity{
    private ActivityOrderBinding binding;
    private RecyclerView.Adapter adapter;
    private OrderList orderList;
    private ManagmentCart managementCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        orderList = new OrderList(this);
        ArrayList<Order> orders = generateOrdersFromCart();

        initList(orders);
    }

    private ArrayList<Order> generateOrdersFromCart() {
        if (managementCart == null){
            Foods item = new Foods();
            managementCart.insertFood(item);
        }
        return managementCart.convertCartToOrder();
    }

    private void initList(ArrayList<Order> orders) {
//        if(orderList.getOrderList();){
            binding.titleTxt.setVisibility(View.VISIBLE);
            binding.emptyTxt.setVisibility(View.GONE);
//        } else {
            binding.titleTxt.setVisibility(View.GONE);
            binding.emptyTxt.setVisibility(View.VISIBLE);
//        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        binding.scrollViewOrder.setLayoutManager(linearLayoutManager);
        adapter = new OrderAdapter(orderList.getOrderList(), this);
        binding.scrollViewOrder.setAdapter(adapter);
    }
}
