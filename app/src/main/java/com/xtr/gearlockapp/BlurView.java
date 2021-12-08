package com.xtr.gearlockapp;

import static android.content.ContentValues.TAG;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;

import androidx.core.app.ActivityCompat;

import java.lang.reflect.Array;

public class BlurView {
    private static WallpaperManager wallpaperManager = null;
    private static Drawable wp;
    private static Bitmap bitmap;
    private static BitmapDrawable bitmapDrawable;

    @SuppressLint("MissingPermission")
    public static Bitmap jFastblur(Context context, int i, float f, int i2) {
        wallpaperManager = WallpaperManager.getInstance(context);
        wp = wallpaperManager.getDrawable();
        bitmapDrawable = (BitmapDrawable) wp;
        bitmap = bitmapDrawable.getBitmap();
        long currentTimeMillis = System.currentTimeMillis();
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, 96, bitmap.getHeight() / (bitmap.getWidth() / 96), true);
        if (i < 1) {
            return null;
        }
        int width = createScaledBitmap.getWidth();
        int height = createScaledBitmap.getHeight();
        int[] iArr = new int[(width * height)];
        Log.e("pix", width + " " + height + " " + iArr.length);
        createScaledBitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int i3 = width - 1;
        int i4 = height - 1;
        int i5 = width * height;
        int i6 = i + i + 1;
        int[] iArr2 = new int[i5];
        int[] iArr3 = new int[i5];
        int[] iArr4 = new int[i5];
        int[] iArr5 = new int[Math.max(width, height)];
        int i7 = (i6 + 1) >> 1;
        int i8 = i7 * i7;
        int[] iArr6 = new int[(i8 * 256)];
        for (int i9 = 0; i9 < i8 * 256; i9++) {
            iArr6[i9] = i9 / i8;
        }
        int i10 = 0;
        int i11 = 0;
        int[][] iArr7 = (int[][]) Array.newInstance(Integer.TYPE, i6, 3);
        int i12 = i + 1;
        for (int i13 = 0; i13 < height; i13++) {
            int i14 = 0;
            int i15 = 0;
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            int i21 = 0;
            int i22 = 0;
            for (int i23 = -i; i23 <= i; i23++) {
                int i24 = iArr[Math.min(i3, Math.max(i23, 0)) + i10];
                int[] iArr8 = iArr7[i23 + i];
                iArr8[0] = (16711680 & i24) >> 16;
                iArr8[1] = (65280 & i24) >> 8;
                iArr8[2] = i24 & 255;
                int abs = i12 - Math.abs(i23);
                i16 += iArr8[0] * abs;
                i15 += iArr8[1] * abs;
                i14 += iArr8[2] * abs;
                if (i23 > 0) {
                    i22 += iArr8[0];
                    i21 += iArr8[1];
                    i20 += iArr8[2];
                } else {
                    i19 += iArr8[0];
                    i18 += iArr8[1];
                    i17 += iArr8[2];
                }
            }
            int i25 = i;
            for (int i26 = 0; i26 < width; i26++) {
                iArr2[i10] = iArr6[i16];
                iArr3[i10] = iArr6[i15];
                iArr4[i10] = iArr6[i14];
                int i27 = i16 - i19;
                int i28 = i15 - i18;
                int i29 = i14 - i17;
                int[] iArr9 = iArr7[((i25 - i) + i6) % i6];
                int i30 = i19 - iArr9[0];
                int i31 = i18 - iArr9[1];
                int i32 = i17 - iArr9[2];
                if (i13 == 0) {
                    iArr5[i26] = Math.min(i26 + i + 1, i3);
                }
                int i33 = iArr[iArr5[i26] + i11];
                iArr9[0] = (16711680 & i33) >> 16;
                iArr9[1] = (65280 & i33) >> 8;
                iArr9[2] = i33 & 255;
                int i34 = i22 + iArr9[0];
                int i35 = i21 + iArr9[1];
                int i36 = i20 + iArr9[2];
                i16 = i27 + i34;
                i15 = i28 + i35;
                i14 = i29 + i36;
                i25 = (i25 + 1) % i6;
                int[] iArr10 = iArr7[i25 % i6];
                i19 = i30 + iArr10[0];
                i18 = i31 + iArr10[1];
                i17 = i32 + iArr10[2];
                i22 = i34 - iArr10[0];
                i21 = i35 - iArr10[1];
                i20 = i36 - iArr10[2];
                i10++;
            }
            i11 += width;
        }
        for (int i37 = 0; i37 < width; i37++) {
            int i38 = 0;
            int i39 = 0;
            int i40 = 0;
            int i41 = 0;
            int i42 = 0;
            int i43 = 0;
            int i44 = 0;
            int i45 = 0;
            int i46 = 0;
            int i47 = (-i) * width;
            for (int i48 = -i; i48 <= i; i48++) {
                int max = Math.max(0, i47) + i37;
                int[] iArr11 = iArr7[i48 + i];
                iArr11[0] = iArr2[max];
                iArr11[1] = iArr3[max];
                iArr11[2] = iArr4[max];
                int abs2 = i12 - Math.abs(i48);
                i40 += iArr2[max] * abs2;
                i39 += iArr3[max] * abs2;
                i38 += iArr4[max] * abs2;
                if (i48 > 0) {
                    i46 += iArr11[0];
                    i45 += iArr11[1];
                    i44 += iArr11[2];
                } else {
                    i43 += iArr11[0];
                    i42 += iArr11[1];
                    i41 += iArr11[2];
                }
                if (i48 < i4) {
                    i47 += width;
                }
            }
            int i49 = i37;
            int i50 = i;
            for (int i51 = 0; i51 < height; i51++) {
                iArr[i49] = (-16777216 & iArr[i49]) | (iArr6[i40] << 16) | (iArr6[i39] << 8) | iArr6[i38];
                int i52 = i40 - i43;
                int i53 = i39 - i42;
                int i54 = i38 - i41;
                int[] iArr12 = iArr7[((i50 - i) + i6) % i6];
                int i55 = i43 - iArr12[0];
                int i56 = i42 - iArr12[1];
                int i57 = i41 - iArr12[2];
                if (i37 == 0) {
                    iArr5[i51] = Math.min(i51 + i12, i4) * width;
                }
                int i58 = i37 + iArr5[i51];
                iArr12[0] = iArr2[i58];
                iArr12[1] = iArr3[i58];
                iArr12[2] = iArr4[i58];
                int i59 = i46 + iArr12[0];
                int i60 = i45 + iArr12[1];
                int i61 = i44 + iArr12[2];
                i40 = i52 + i59;
                i39 = i53 + i60;
                i38 = i54 + i61;
                i50 = (i50 + 1) % i6;
                int[] iArr13 = iArr7[i50];
                i43 = i55 + iArr13[0];
                i42 = i56 + iArr13[1];
                i41 = i57 + iArr13[2];
                i46 = i59 - iArr13[0];
                i45 = i60 - iArr13[1];
                i44 = i61 - iArr13[2];
                i49 += width;
            }
        }
        Log.d("pix", width + " " + height + " " + iArr.length);
        createScaledBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
        new Canvas(createScaledBitmap).drawARGB(i2, 0, 0, 0);
        Log.d(TAG, "jFastblur take" + String.valueOf(System.currentTimeMillis() - currentTimeMillis) + " millis sec.");
        return createScaledBitmap;
    }
}
