package com.kimhao.company;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Hello World
 * Created by haolek on 14/12/2017.
 */

public class SlideAdapter extends FragmentStatePagerAdapter {
    private int[] mImages;

    public SlideAdapter(FragmentManager fm, int[] images) {
        super(fm);
        this.mImages = images;
    }

    @Override
    public Fragment getItem(int position) {
        if (position < mImages.length) {
            return ImageSlide.newInstance(mImages[position]);
        } else
            return null;
    }

    @Override
    public int getCount() {
        return mImages.length;
    }
}
