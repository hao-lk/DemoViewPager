package com.kimhao.company;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by haolek on 14/12/2017.
 */

public class TabFragment extends Fragment {
    public static final int DIALOG_FRAGMENT = 1;
    public static final String KEY_NAME = "name";
    TextView mTvName;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.tab_fragment, container, false);
        Button btnUpdate = view.findViewById(R.id.btnUpdate);
        mTvName = view.findViewById(R.id.tvTabFragment);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("CommitTransaction")
            @Override
            public void onClick(View view) {
                UpdateDialog updateDialog = new UpdateDialog();
                updateDialog.setTargetFragment(getParentFragment(), DIALOG_FRAGMENT);
                updateDialog.show(getChildFragmentManager().beginTransaction(), "DialogUpdate");
            }
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == DIALOG_FRAGMENT && resultCode == Activity.RESULT_OK) {
            mTvName.setText(data.getStringExtra(KEY_NAME));
        }
    }
}
