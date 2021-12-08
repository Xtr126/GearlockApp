package com.xtr.gearlockapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ScrollingFragment extends Fragment {
    interface OnOptionClickListener {
        void onOptionSelected(String option);
    }

    private OnOptionClickListener mCallback;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mCallback = (OnOptionClickListener) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_scrolling, container, false);

        LinearLayout mGxpm = rootView.findViewById(R.id.installOption);
        LinearLayout mExtensions = rootView.findViewById(R.id.extensionsOption);
        LinearLayout mSupercharge = rootView.findViewById(R.id.superchargeOption);
        LinearLayout mBackup = rootView.findViewById(R.id.backupOption);
        LinearLayout mGames = rootView.findViewById(R.id.gamesOption);
        LinearLayout mExtraMisc = rootView.findViewById(R.id.extra_miscOption);
        LinearLayout mSystem = rootView.findViewById(R.id.systemOption);
        LinearLayout mSysmask = rootView.findViewById(R.id.system_maskOption);

        mGxpm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.onOptionSelected("gxpmInstall");
            }
        });
        mExtensions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.onOptionSelected("runExtensions");
            }
        });
        mSupercharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.onOptionSelected("Supercharge");
            }
        });
        mBackup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.onOptionSelected("Backup");
            }
        });
        mGames.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.onOptionSelected("Games");
            }
        });
        mExtraMisc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.onOptionSelected("ExtraMisc");
            }
        });
        mSystem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.onOptionSelected("SystemTweaks");
            }
        });
        mSysmask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.onOptionSelected("Dashboard");
            }
        });

        return rootView;
    }

}