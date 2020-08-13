package com.example.mynotes.fragment.video;

import com.affectiva.android.affdex.sdk.Frame;
import com.affectiva.android.affdex.sdk.detector.Face;
import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@IgnoreExtraProperties
public class mood {
    List<Face> faces;
    public String userID;
    public String anger;
    public String contempt;
    public  String disgust;
    public String fear;
    public  String joy;
    public String sadness;
    public String surprise;
    public int starCount = 0;
    public Map<String, Boolean> stars = new HashMap<>();

    public mood(String userID, String anger, String contempt, String disgust, String fear, String joy, String sadness, String surprise){
        this.anger = anger;
        this.contempt = contempt;
        this.disgust =disgust;
        this.fear = fear;
        this.joy = joy;
        this.sadness =sadness;
        this.surprise = surprise;
        this.userID = userID;
    }
    @Exclude
    public Map<String, Object> toMap() {


        HashMap<String, Object> result = new HashMap<>();
        result.put(" users",  userID);
        result.put(" anger",  anger);
        result.put(" contempt", contempt);
        result.put(" disgust",  disgust);
        result.put("  fear",   fear);;
        result.put(" joy",joy);
        result.put(" surprise",  surprise);
        result.put(" starCount",  starCount);
        result.put(" sadness",  stars);
        return result;
    }

}

