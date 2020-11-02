package com.vimalcvs.switchdn.example.ui;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatDelegate;

/**
 * Created by VimalCvs on 02/11/2020.
 */

public class ThemeSettings {

    private static ThemeSettings instance;

    public static ThemeSettings getInstance(Context context) {
        if (instance == null) instance = new ThemeSettings(context);
        return instance;
    }

    private static class Key {
        private static final String NIGHT_MODE = "nightMode";
    }

    public boolean nightMode;

    private ThemeSettings(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("settings", Context.MODE_PRIVATE);
        nightMode = prefs.getBoolean(Key.NIGHT_MODE, false);
    }

    public void save(Context context) {
        SharedPreferences.Editor editor = context.getSharedPreferences("settings", Context.MODE_PRIVATE).edit();
        editor.putBoolean(Key.NIGHT_MODE, nightMode);
        editor.apply();
    }

    public void refreshTheme() {
        AppCompatDelegate.setDefaultNightMode(nightMode ?
                AppCompatDelegate.MODE_NIGHT_YES :
                AppCompatDelegate.MODE_NIGHT_NO);
    }
}
