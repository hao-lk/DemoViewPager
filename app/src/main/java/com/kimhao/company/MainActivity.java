package com.kimhao.company;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private String[] mStrings = {"Tab 1", "Tab 2", "Tab 3"};
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = findViewById(R.id.viewpager);
        PagerAdapter pagerAdapter = new PagerAdapter(MainActivity.this, mStrings);
        mViewPager.setAdapter(pagerAdapter);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //g
//                if (position == mStrings.length) {
//                    startActivity(new Intent(MainActivity.this, SecondActivity.class));
//                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
