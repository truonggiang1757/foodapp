package com.example.lbtg1.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lbtg1.Domain.Order;
import com.example.lbtg1.Helper.ChangeNumberItemsListener;
import com.example.lbtg1.Helper.OrderList;
import com.example.lbtg1.R;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.viewholder>{
    ArrayList<Order> list;
    private OrderList orderList;
    ChangeNumberItemsListener changeNumberItemsListener;
    public OrderAdapter(ArrayList<Order> list, Context context) {
        this.list = list;
        orderList = new OrderList(context);
    }

    @NonNull
    @Override
    public OrderAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_ordered_items, parent, false);
        return new viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderAdapter.viewholder holder, int position) {
        holder.dateTime.setText(list.get(position).getOrderTitle());
        holder.status.setText("Status: " + list.get(position).getStatus());
        holder.total.setText(list.get(position).getTotalPrice() + "VND");
    }

    @Override
    public int getItemCount() {
        return 0;
    }
    public class viewholder extends RecyclerView.ViewHolder{
        TextView dateTime, status, total;
        public viewholder(@NonNull View itemView) {
            super(itemView);

            dateTime = itemView.findViewById(R.id.dateTimeTxt);
            status = itemView.findViewById(R.id.statusTxt);
            total = itemView.findViewById(R.id.totalTxt);
        }
    }
}
