package com.example.tobomanager06.fragment;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatEditText;
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

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.tobomanager06.R;
import com.example.tobomanager06.databinding.ActivityMainBinding;
import com.example.tobomanager06.databinding.FragmentCreateTaskBinding;


public class CreateTaskFragment extends Fragment {

     FragmentCreateTaskBinding binding;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentCreateTaskBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initClickers();
    }

    private void initClickers() {
        binding.applyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendText();
            }
        });
    }

    private void sendText() {
        String text = binding.taskEd.getText().toString();
        if (text.isEmpty()) {
            binding.taskEd.setError("Ошибка");
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("key", text);
            Navigation.findNavController(requireView()).navigate(R.id.homeFragment, bundle);
        }
    }
}
