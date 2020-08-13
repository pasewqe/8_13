package com.example.mynotes.fragment;

import android.os.Bundle;

import com.example.mynotes.R;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;


public class new_MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private new_viewpageradapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("生命存款簿");

        tabLayout = (TabLayout) findViewById(R.id.tabLayout_id);
        viewPager = (ViewPager) findViewById(R.id.viewpager_id);
        adapter = new new_viewpageradapter(getSupportFragmentManager());

       //Add fragment here
        adapter.AddFragment(new new_fragment(),"note");
        adapter.AddFragment(new new_secondfragment(),"video");
        adapter.AddFragment(new new_third_fragment(),"paper");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_baseline_event_note_24);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_baseline_videocam_24);



    }



}
