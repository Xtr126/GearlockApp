package com.xtr.gearlockapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ScrollingFragment extends Fragment {
    public interface OnOptionClickListener {
        void onOptionSelected(String option);
    }

    private OnOptionClickListener mCallback;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mCallback = (OnOptionClickListener) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_scrolling, container, false);

        LinearLayout mGxpm = rootView.findViewById(R.id.installOption);
        LinearLayout mExtensions = rootView.findViewById(R.id.extensionsOption);
        LinearLayout mSupercharge = rootView.findViewById(R.id.superchargeOption);
        LinearLayout mBackup = rootView.findViewById(R.id.backupOption);
        LinearLayout mGames = rootView.findViewById(R.id.gamesOption);
        LinearLayout mExtraMisc = rootView.findViewById(R.id.extra_miscOption);
        LinearLayout mSystem = rootView.findViewById(R.id.systemOption);
        LinearLayout mSysmask = rootView.findViewById(R.id.system_maskOption);

        mGxpm.setOnClickListener(view -> mCallback.onOptionSelected("gxpmInstall"));
        mExtensions.setOnClickListener(view -> mCallback.onOptionSelected("runExtensions"));
        mSupercharge.setOnClickListener(view -> mCallback.onOptionSelected("Supercharge"));
        mBackup.setOnClickListener(view -> mCallback.onOptionSelected("Backup"));
        mGames.setOnClickListener(view -> mCallback.onOptionSelected("Games"));
        mExtraMisc.setOnClickListener(view -> mCallback.onOptionSelected("ExtraMisc"));
        mSystem.setOnClickListener(view -> mCallback.onOptionSelected("SystemTweaks"));
        mSysmask.setOnClickListener(view -> mCallback.onOptionSelected("Dashboard"));

        return rootView;
    }

}