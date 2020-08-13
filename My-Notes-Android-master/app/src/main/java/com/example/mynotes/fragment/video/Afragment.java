package com.example.mynotes.fragment.video;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.affectiva.android.affdex.sdk.Frame;
import com.affectiva.android.affdex.sdk.detector.CameraDetector;
import com.affectiva.android.affdex.sdk.detector.Detector;
import com.affectiva.android.affdex.sdk.detector.Face;
import com.example.mynotes.R;
import com.example.mynotes.fragment.note.MainActivity;
import com.example.mynotes.fragment.note.NotesRecyclerAdapter;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.Timestamp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import static java.lang.Thread.sleep;


public class Afragment extends AppCompatActivity implements Detector.ImageListener {
    public static final String TAG = "TAG";
    private Uri uri;
    int i = 0;

    VideoView videoView;
    SurfaceView cameraview;
    CameraDetector detector;
    View view;
    FirebaseFirestore fStore = FirebaseFirestore.getInstance();
    FirebaseAuth fAuth;
    String userID;
    NotesRecyclerAdapter notesRecyclerAdapter;
    private DatabaseReference mDatabase;
    List<Face> faces = new ArrayList<>();
    Frame frame;
    String anger, contempt, disgust, fear, joy, sadness, surprise;
    FloatingActionButton Next;
    private DocumentReference documentReference = fStore.document("notes/face");

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_play);
        videoView = findViewById(R.id.videoView);
        Bundle bundle = getIntent().getExtras();
        view = findViewById(R.id.view3);
        cameraview = findViewById(R.id.camera_view);
        view.setBackgroundColor(Color.parseColor("#6495ED"));
        Next = findViewById(R.id.next);
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();


        VideoView videoView = (VideoView) findViewById(R.id.videoView);
        MediaController mediaController = new MediaController(this);

        Uri videouri = Uri.parse("https://firebasestorage.googleapis.com/v0/b/test-55cf4.appspot.com/o/%E8%AA%B2%E7%A8%8B%E5%85%A7%E5%AE%B9%E4%B8%8D%E6%98%93%E7%90%86%E8%A7%A3.mp4?alt=media&token=422c5af0-b750-4b0c-86ae-a6f7d99084d8");
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(videouri);
        videoView.start();

        detector = new CameraDetector(this, CameraDetector.CameraType.CAMERA_FRONT, cameraview);
        detector.setImageListener(this);
        //detector.setDetectSmile(true);
        detector.setDetectAllEmotions(true);
        //detector.setDetectAllAppearances(true);
        detector.setMaxProcessRate(60);
        detector.start();


    }

    @Override
    protected void onStart() {
        super.onStart();
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException e) {
                if (e != null) {
                    Toast.makeText(Afragment.this, "ERROR", Toast.LENGTH_SHORT).show();
                    Log.d(TAG, e.toString());
                    return;
                }

            }
        });
    }



    @Override
    public void onImageResults(List<Face> faces, Frame frame, float v) {


        if (faces.size() == 0) {
            view.setBackgroundColor(Color.parseColor("#FF0000"));
        } else {
            view.setBackgroundColor(Color.parseColor("#00FF00"));
            i++;
            String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
            String s = String.valueOf(i);
            DocumentReference documentReference = fStore.collection("mood").document("face"+userId+s);
            Face face = faces.get(0);
            
            anger = String.valueOf(face.emotions.getAnger());
            contempt = String.valueOf(face.emotions.getContempt());
            disgust = String.valueOf(face.emotions.getDisgust());
            fear = String.valueOf(face.emotions.getFear());
            joy = String.valueOf(face.emotions.getJoy());
            sadness = String.valueOf(face.emotions.getSadness());
            surprise = String.valueOf(face.emotions.getSurprise());
            Map<String, Object> user = new HashMap<>();

            user.put("time",new Timestamp(new Date()));
            user.put("anger", anger);
            user.put("contempt", contempt);
            user.put("disgust", disgust);
            user.put("fear", fear);
            user.put(" joy", joy);
            user.put("sadness", sadness);
            user.put("surprise", surprise);
            documentReference.set(user)
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(Afragment.this, "not saved", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(Afragment.this, "error", Toast.LENGTH_SHORT).show();
                            Log.d(TAG, e.toString());
                        }
                    });

        }

    }
    @Override
    public void onBackPressed() {
        if(detector.isRunning()) {
            detector.stop();
        }
        super.onBackPressed();
    }
}
    


