package com.example.newsapp.AdapterClasses;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.newsapp.Fragments.BusinessFragment;
import com.example.newsapp.Fragments.EntertainmentFragment;
import com.example.newsapp.Fragments.HealthFragment;
import com.example.newsapp.Fragments.HomeFragment;
import com.example.newsapp.Fragments.ScienceFragment;
import com.example.newsapp.Fragments.SportsFragment;
import com.example.newsapp.Fragments.TechFragment;


public class FragmentAdapter extends FragmentPagerAdapter {

    public FragmentAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        if (position==0){
          return new HomeFragment();
        }
        else if (position==1){
            return new HealthFragment();
        }else if (position==2){
            return new ScienceFragment();
        }else if (position==3){
            return new EntertainmentFragment();
        }else if (position==4){
            return new SportsFragment();
        }else if (position==5){
            return new BusinessFragment();
        }else{
            return new TechFragment();
        }
    }

    @Override
    public int getCount() {
        return 7;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position==0){
            return "General";
        }else if (position==1){
            return "Health";
        }else if (position==2){
            return "Science";
        }else if (position==3){
            return "Entertainment";
        }else if (position==4){
            return "Sports";
        }else if (position==5){
            return "Business";
        }else{
            return "Technology";
        }
    }
}
