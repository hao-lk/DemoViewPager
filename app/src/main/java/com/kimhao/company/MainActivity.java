package com.kimhao.company;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.rd.PageIndicatorView;
import com.rd.draw.data.Orientation;

public class MainActivity extends AppCompatActivity {

    private String[] mStrings = {"Tab 1", "Tab 2", "Tab 3"};
    private ViewPager mViewPager;
    private TextView mTvSkip;
    private PageIndicatorView mPageIndicatorView;
    private Boolean mIsLastViewPager = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = findViewById(R.id.viewpager);
        mTvSkip = findViewById(R.id.tvSkip);
        mPageIndicatorView = findViewById(R.id.pageIndicator);

        PagerAdapter pagerAdapter = new PagerAdapter(MainActivity.this, mStrings);
        mViewPager.setAdapter(pagerAdapter);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                // last viewpager
                mIsLastViewPager = position == mStrings.length - 1;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                // Check if it last viewpager and scroll
                if (mIsLastViewPager && state == ViewPager.SCROLL_STATE_DRAGGING) {
                    startActivity(new Intent(MainActivity.this, SecondActivity.class));
                    mIsLastViewPager = false;
                }
            }
        });

        mPageIndicatorView.setViewPager(mViewPager);
        mPageIndicatorView.setCount(mStrings.length);
        mPageIndicatorView.setOrientation(Orientation.HORIZONTAL);
        mPageIndicatorView.setDynamicCount(true);

        mTvSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });
    }
}
