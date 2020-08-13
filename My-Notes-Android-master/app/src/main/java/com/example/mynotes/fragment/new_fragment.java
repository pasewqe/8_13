package com.example.mynotes.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.mynotes.fragment.note.MainActivity;
import com.example.mynotes.R;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class new_fragment extends Fragment {


    private static final String TAG = "alex";
    private Button btnFragment_a, btnFragment_b, btnFragment_c;


    View v;

    public static new_fragment newInstance() {
        new_fragment f = new new_fragment();
        Bundle arg = new Bundle();
        f.setArguments(arg);
        return f;


    }

    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }


    public new_fragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.new_fragment,container,false);
        btnFragment_a = (Button) v.findViewById(R.id.btn_fragment_a);


        btnFragment_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), MainActivity.class));
            }
        });

        return v;
    }


}