package com.example.tobomanager06.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tobomanager06.R;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tobomanager06.R;
import com.example.tobomanager06.adapter.HomeAdapter;
import com.example.tobomanager06.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    String text;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getData();
        initClickers();
        initAdapter();
    }

    private String getData()  {
        if (getArguments() != null) {
            text = getArguments().getString("key");
            return text;
        }
        return "";
    }

    private void initAdapter() {
        HomeAdapter homeAdapter = new HomeAdapter();
        binding.homeRecycler.setAdapter(homeAdapter);
        if (!getData().isEmpty()){
            homeAdapter.addText(text);
        }
    }

    private void initClickers() {
        binding.openCreateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(requireView()).navigate(R.id.createTaskFragment);
            }
        });
    }
}