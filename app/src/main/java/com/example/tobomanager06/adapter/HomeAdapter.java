package com.example.tobomanager06.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.tobomanager06.R;
import com.example.tobomanager06.databinding.ItemTaskBinding;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeHolder> {
    private ItemTaskBinding binding;
    ArrayList<String> list = new ArrayList<>();

    @NonNull
    @Override
    public HomeAdapter.HomeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemTaskBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new HomeHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.HomeHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addText(String text) {
        list.add(text);

    }

    public class HomeHolder extends RecyclerView.ViewHolder {

        public HomeHolder(@NonNull ItemTaskBinding binding) {
            super(binding.getRoot());
        }

        public void onBind(String text) {
            binding.titleTv.setText(text);
        }
    }
}


