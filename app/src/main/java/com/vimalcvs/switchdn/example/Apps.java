package com.vimalcvs.switchdn.example;

import android.app.Application;
import com.vimalcvs.switchdn.example.ui.ThemeSettings;

/**
 * Created by VimalCvs on 02/11/2020.
 */

public class Apps extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ThemeSettings.getInstance(this).refreshTheme();
    }
}
