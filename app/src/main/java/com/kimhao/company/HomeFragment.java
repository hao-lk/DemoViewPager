package com.kimhao.company;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomeFragment extends Fragment {
    private static final int[] IMAGES = {R.drawable.ic_logo, R.drawable.ic_logo_1, R.drawable.ic_logo_2};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ViewPager viewPager = view.findViewById(R.id.viewPageImage);
        SlideAdapter slideAdapter = new SlideAdapter(getChildFragmentManager(), IMAGES);
        viewPager.setAdapter(slideAdapter);
        return view;
    }
}
