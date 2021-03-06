package com.example.module_two;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    ViewPagerFragment.ViewPagerFragmentAdapter viewPagerFragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.my_view_pager);
        viewPagerFragmentAdapter = new ViewPagerFragment.ViewPagerFragmentAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerFragmentAdapter);
    }
}
