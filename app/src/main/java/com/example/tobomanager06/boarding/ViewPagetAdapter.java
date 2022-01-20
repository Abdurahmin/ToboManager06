package com.example.tobomanager06.boarding;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tobomanager06.databinding.FragmentBoardBinding;
import com.example.tobomanager06.databinding.ItemTaskBinding;
import com.example.tobomanager06.model.ViewPagerModel;

import java.util.ArrayList;

public class ViewPagetAdapter extends RecyclerView.Adapter<ViewPagetAdapter.ViewPagerHolder> {

    ArrayList<ViewPagerModel> listPager;

    public ViewPagetAdapter(ArrayList<ViewPagerModel> listPager) {
        this.listPager = listPager;
    }

    @NonNull
    @Override
    public ViewPagerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewPagerHolder(FragmentBoardBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewPagerHolder holder, int position) {
        holder.onBind(listPager.get(position));
    }

    @Override
    public int getItemCount() {
        return listPager.size();
    }

    public class ViewPagerHolder extends RecyclerView.ViewHolder {
        private FragmentBoardBinding binding;

        public ViewPagerHolder(@NonNull FragmentBoardBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(ViewPagerModel model) {
            binding.titleTv.setText(model.getTitle());
            binding.descriptionTv.setText(model.getDescription());
            binding.imageView.setImageResource(model.getImage());
        }
    }
}
