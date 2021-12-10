package com.xtr.gearlockapp;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.xtr.gearlockapp.fragments.Backup;
import com.xtr.gearlockapp.fragments.Extensions;
import com.xtr.gearlockapp.fragments.ExtraMisc;
import com.xtr.gearlockapp.fragments.GameSystemTweaks;
import com.xtr.gearlockapp.fragments.GxpmFragment;
import com.xtr.gearlockapp.fragments.Supercharge;
import com.xtr.gearlockapp.fragments.SystemMaskDashboard;

public class MainActivity extends AppCompatActivity implements ScrollingFragment.OnOptionClickListener {
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        if (!hasStoragePermission()) {
            requestStoragePermission(0);
        }
        if (savedInstanceState == null) {
            fragmentManager.beginTransaction()
                    .add(R.id.container, new ScrollingFragment())
                    .commit();
        }
        applyBackground();
    }

    public boolean hasStoragePermission() {
        return Build.VERSION.SDK_INT < 23 || checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void requestStoragePermission(int code) {
        requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, code);
    }

    public void applyBackground(){
        Bitmap bitmap = BlurView.jFastblur(this,6,7.5f,120);
        Drawable drawable = new BitmapDrawable(getResources(), bitmap);
        LinearLayout linearlayout = findViewById(R.id.main_layout);
        linearlayout.setBackground(drawable);
    }

    @Override
    public void onOptionSelected(String option) {
        switch (option) {
            case "gxpmInstall": {
                fragmentManager.beginTransaction()
                        .replace(R.id.detailContainer, new GxpmFragment())
                        .commit();
                break;
            }
            case "runExtensions": {
                fragmentManager.beginTransaction()
                        .replace(R.id.detailContainer, new Extensions())
                        .commit();
                break;
            }
            case "Supercharge":
            case "Games": {
                fragmentManager.beginTransaction()
                        .replace(R.id.detailContainer, new Supercharge())
                        .commit();
                break;
            }
            case "Backup": {
                fragmentManager.beginTransaction()
                        .replace(R.id.detailContainer, new Backup())
                        .commit();
                break;
            }
            case "ExtraMisc": {
                fragmentManager.beginTransaction()
                        .replace(R.id.detailContainer, new ExtraMisc())
                        .commit();
                break;
            }
            case "SystemTweaks": {
                fragmentManager.beginTransaction()
                        .replace(R.id.detailContainer, new GameSystemTweaks())
                        .commit();
                break;
            }
            case "Dashboard": {
                fragmentManager.beginTransaction()
                        .replace(R.id.detailContainer, new SystemMaskDashboard())
                        .commit();
                break;
            }
        }
    }
}
