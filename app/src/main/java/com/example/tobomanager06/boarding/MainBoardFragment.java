package com.example.tobomanager06.boarding;

import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tobomanager06.R;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tobomanager06.R;
import com.example.tobomanager06.databinding.ActivityMainBinding;
import com.example.tobomanager06.databinding.FragmentBoardBinding;
import com.example.tobomanager06.databinding.FragmentMainBoardBinding;
import com.example.tobomanager06.databinding.ItemTaskBinding;
import com.example.tobomanager06.model.ViewPagerModel;

import java.text.CollationElementIterator;
import java.util.ArrayList;


public class MainBoardFragment extends Fragment {


    private FragmentMainBoardBinding binding;
    ViewPagetAdapter adapter;
    ArrayList<ViewPagerModel> list = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentMainBoardBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        list.add(new ViewPagerModel("1", "1", R.drawable.ic_launcher_background));
        list.add(new ViewPagerModel("2", "2", R.drawable.ic_launcher_background));
        list.add(new ViewPagerModel("3", "3", R.drawable.ic_launcher_background));
        adapter = new ViewPagetAdapter(list);
        binding.viewpager.setAdapter(adapter);

    }

    private void checkOnShow() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("shared_presf", Context.MODE_PRIVATE);
        boolean isShow = sharedPreferences.getBoolean("isShow", false);
        if (isShow) {
            Navigation.findNavController(requireView()).navigate(R.id.homeFragment);
        }
    }

    public void itemClick() {
        Navigation.findNavController(requireView()).navigate(R.id.homeFragment);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("shared_presf", Context.MODE_PRIVATE);
        sharedPreferences.edit().putBoolean("isShow", true).apply();
    }
}
