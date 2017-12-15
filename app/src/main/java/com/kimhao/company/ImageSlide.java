package com.kimhao.company;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Hello World
 * Created by haolek on 14/12/2017.
 */

public class ImageSlide extends Fragment {
    private static final String ARG_RESOURCE_ID = "resource_id";
    private int mId;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mId = getArguments().getInt(ARG_RESOURCE_ID);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_viewpager_slide, container, false);
        ImageView imgView = view.findViewById(R.id.imgSlide);
        imgView.setImageResource(mId);
        return view;
    }

    public static ImageSlide newInstance(int id) {
        ImageSlide imageSlide = new ImageSlide();
        Bundle args = new Bundle();
        args.putInt(ARG_RESOURCE_ID, id);
        imageSlide.setArguments(args);
        return imageSlide;
    }
}
