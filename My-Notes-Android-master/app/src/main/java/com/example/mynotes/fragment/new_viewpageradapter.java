package com.example.mynotes.fragment;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class new_viewpageradapter extends FragmentPagerAdapter {

    private final List<Fragment> onefragment = new ArrayList<>();
    private  final List<String> onetitle = new ArrayList<>();


    public new_viewpageradapter(FragmentManager fm){
        super(fm);

    }

    @Override
    public Fragment getItem(int position){
        return  onefragment.get(position);
    }

    @Override
    public int getCount(){
        return onetitle.size();
    }

    @Override
    public CharSequence getPageTitle(int position){
        return onetitle.get(position);
    }

    public  void AddFragment(Fragment fragment, String title){
        onefragment.add(fragment);
        onetitle.add(title);
    }
}
