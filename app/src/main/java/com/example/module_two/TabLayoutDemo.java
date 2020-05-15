package com.example.module_two;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class TabLayoutDemo extends AppCompatActivity {
    ViewPager viewPager;
    TabLayout tabLayout;
    TabLayoutFragmentAdapter tabLayoutFragmentAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout_demo);
        viewPager = (ViewPager) findViewById(R.id.my_view_pager_2);
        tabLayout = (TabLayout) findViewById(R.id.my_tab_layout);
        tabLayout.setupWithViewPager(viewPager);
        tabLayoutFragmentAdapter = new TabLayoutFragmentAdapter(getSupportFragmentManager(), TabLayoutDemo.this);
        viewPager.setAdapter(tabLayoutFragmentAdapter);

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            tabLayout.getTabAt(i).setCustomView(tabLayoutFragmentAdapter.getTab(R.layout.tab_item_layout,i));
        }

    }
}

