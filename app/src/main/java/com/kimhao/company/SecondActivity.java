package com.kimhao.company;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        setupViewPager();
    }


    private void setupViewPager() {
        final ViewPager viewPager = findViewById(R.id.viewpagerImage);
        setupViewPager(viewPager);

        TabLayout tabLayout = findViewById(R.id.tabTitle);
        tabLayout.setupWithViewPager(viewPager);
    }


    private void setupViewPager(ViewPager viewPager) {
        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new TabFragment(), "Information");
        adapter.addFrag(new TabFragment(), "Programm");
        adapter.addFrag(new TabFragment(), "Price");
        adapter.addFrag(new TabFragment(), "Media");

        viewPager.setAdapter(adapter);
    }

}
