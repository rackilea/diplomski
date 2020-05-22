package com.tesmachino.saycure;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tesmachino.saycure.entities.OrderHistory.OrderHistoryResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;


public class OrderHistoryRecyclerAdapter extends RecyclerView.Adapter<OrderHistoryRecyclerAdapter.ViewHolder> {

 private List<OrderHistoryGet> data;


  public OrderHistoryRecyclerAdapter(List<OrderHistoryGet> data){
          this.data = data;
   }
    @NonNull
    @Override
    public OrderHistoryRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item.xml, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderHistoryRecyclerAdapter.ViewHolder holder, int position) {

      OrderHistoryGet obj = data.get(position);

      holder.order_id.setText(obj.getId()+"");

    }

    @Override
    public int getItemCount() {

        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView order_id;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            order_id = (TextView) itemView.findViewById(R.id.orderid);

        }
    }
}