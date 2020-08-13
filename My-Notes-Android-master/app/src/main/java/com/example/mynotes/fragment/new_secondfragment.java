package com.example.mynotes.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.VideoView;

import com.affectiva.android.affdex.sdk.Frame;
import com.affectiva.android.affdex.sdk.detector.CameraDetector;
import com.affectiva.android.affdex.sdk.detector.Face;
import com.example.mynotes.R;
import com.example.mynotes.fragment.video.Afragment;
import com.example.mynotes.fragment.video.mood;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import static java.lang.Thread.sleep;

public class new_secondfragment extends Fragment {


    FirebaseFirestore fStore;
    FirebaseAuth fAuth;
    List<Face> faces = new ArrayList<>();
    Frame frame;
    String anger,contempt,disgust, fear, joy,sadness,surprise;
    VideoView videoView;
    SurfaceView cameraview;
    CameraDetector detector;
    View v;
    String userID;
    private Button btnFragment_a, btnFragment_b, btnFragment_c;
    private DatabaseReference mDatabase;
    public new_secondfragment() {

    }
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){

            v = inflater.inflate(R.layout.new_secondfragment,container,false);
            btnFragment_a = (Button) v.findViewById(R.id.btn_fragment_a);
            btnFragment_b = v.findViewById(R.id.btn_fragment_b);
            btnFragment_c = v.findViewById(R.id.btn_fragment_c);
            fAuth = FirebaseAuth.getInstance();
            fStore = FirebaseFirestore.getInstance();
            mDatabase = FirebaseDatabase.getInstance().getReference();
            btnFragment_a.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                        startActivity(new Intent(getActivity(), Afragment.class));


                    }

            });

            return v;
        }
    }


