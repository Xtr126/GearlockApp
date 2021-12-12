package com.xtr.gearlockapp.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.xtr.gearlockapp.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;


public class GxpmFragment extends Fragment {


    private TextView textView;
    private View mainView;

    public String runAsRoot(String cmd) {

        try {
            Process process = Runtime.getRuntime().exec(cmd);

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            int read;
            char[] buffer = new char[4096];
            StringBuffer output = new StringBuffer();
            while ((read = reader.read(buffer)) > 0) {
                output.append(buffer, 0, read);
            }
            reader.close();

            process.waitFor();

            return output.toString();

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.gxpm_fragment, container, false);
        Button mInstallFromFile = rootView.findViewById(R.id.button);
        Button mInstallFromGearload = rootView.findViewById(R.id.button2);
        Button mUninstall = rootView.findViewById(R.id.button3);
        Button mViewLog = rootView.findViewById(R.id.button4);

        mInstallFromFile.setOnClickListener(view -> {
            Intent chooseFile = new Intent(Intent.ACTION_OPEN_DOCUMENT);
            chooseFile.addCategory(Intent.CATEGORY_OPENABLE);
            chooseFile.setType("*/*");
            startActivityForResult(chooseFile, 1);

        });
        mInstallFromGearload.setOnClickListener(view -> {

        });
        mUninstall.setOnClickListener(view -> {

        });
        mViewLog.setOnClickListener(view -> {

        });
        return rootView;
    }

    private void setViewLayout(View mainView) {
        ViewGroup rootView = (ViewGroup) getView();
        rootView.removeAllViews();
        rootView.addView(mainView);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mainView = inflater.inflate(R.layout.supercharge_fragment, null);
        setViewLayout(mainView);
        textView = mainView.findViewById(R.id.textView1);

        if (requestCode == 1
                && resultCode == Activity.RESULT_OK) {
            Uri openUri = null;
            if (data != null) {
                openUri = data.getData();
                File file = new File(openUri.getPath());//create path from uri
                final String[] split = file.getPath().split(":");//split the path.
                textView.setText(runAsRoot("gsudo gxpm -i \"/sdcard/" + split[1] + "\""));
            }
        }
    }
}