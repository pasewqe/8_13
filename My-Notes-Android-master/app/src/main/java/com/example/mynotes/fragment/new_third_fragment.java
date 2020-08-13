package com.example.mynotes.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mynotes.R;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class new_third_fragment extends Fragment {

    View v;

    public new_third_fragment() {
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        v = inflater.inflate(R.layout.new_third_fragment,container,false);
        return v;
    }
}