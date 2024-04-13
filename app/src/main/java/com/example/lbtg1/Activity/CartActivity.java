package com.example.lbtg1.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lbtg1.Adapter.CartAdapter;
import com.example.lbtg1.Helper.ManagmentCart;
import com.example.lbtg1.databinding.ActivityCartBinding;

public class CartActivity extends BaseActivity {
    private ActivityCartBinding binding;
    private RecyclerView.Adapter adapter;
    private ManagmentCart managementCart;
    private double tax;
    int main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        managementCart = new ManagmentCart(this);

        setVariable();
        calculateCart();
        initList();
    }

    private void initList() {
        if(managementCart.getListCart().isEmpty()){
            binding.emptyTxt.setVisibility(View.VISIBLE);
            binding.scrollviewCart.setVisibility(View.GONE);
        } else {
            binding.emptyTxt.setVisibility(View.GONE);
            binding.scrollviewCart.setVisibility(View.VISIBLE);
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        binding.cardView.setLayoutManager(linearLayoutManager);
        adapter = new CartAdapter(managementCart.getListCart(), this, () -> calculateCart());
        binding.cardView.setAdapter(adapter);
    }

    private void calculateCart() {
        double percentTax = 0.05;
        double delivery = 30000;

        tax = Math.round(managementCart.getTotalFee()*percentTax*100.0)/100;

        double total = Math.round(managementCart.getTotalFee()+tax+delivery * 100)/100;
        double itemTotal = Math.round(managementCart.getTotalFee() * 100)/100;

        binding.totalFeeTxt.setText(itemTotal+"VND");
        binding.taxTxt.setText(tax + "VND");
        binding.deliveryTxt.setText(delivery + "VND");
        binding.totalTxt.setText(total + "VND");
    }

    private void setVariable() {
        binding.backBtn.setOnClickListener(v -> finish());
        binding.button3.setOnClickListener(v -> startActivity(new Intent(CartActivity.this, OrderActivity.class)));
    }
}