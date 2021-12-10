package com.xtr.gearlockapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.xtr.gearlockapp.R;


public class GxpmFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.gxpm_fragment, container, false);

        Button mInstallFromFile = rootView.findViewById(R.id.button);
        Button mInstallFromGearload = rootView.findViewById(R.id.button2);
        Button mUninstall = rootView.findViewById(R.id.button3);
        Button mViewLog = rootView.findViewById(R.id.button4);

        mInstallFromFile.setOnClickListener(view -> {

        });
        mInstallFromGearload.setOnClickListener(view -> {

        });
        mUninstall.setOnClickListener(view -> {

        });
        mViewLog.setOnClickListener(view -> {

        });
        return rootView;
    }

}