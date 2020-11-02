package com.vimalcvs.switchdn.example;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.vimalcvs.switchdn.DayNightSwitch;
import com.vimalcvs.switchdn.DayNightSwitchAnimListener;
import com.vimalcvs.switchdn.DayNightSwitchListener;
import com.vimalcvs.switchdn.example.ui.ThemeSettings;

/**
 * Created by VimalCvs on 02/11/2020.
 */

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DayNightSwitch dayNightSwitch = (DayNightSwitch)findViewById(R.id.switch_item);
        dayNightSwitch.setDuration(450);
        dayNightSwitch.setIsNight(ThemeSettings.getInstance(this).nightMode);
        dayNightSwitch.setListener(new DayNightSwitchListener() {
            @Override
            public void onSwitch(boolean isNight) {
                ThemeSettings.getInstance(MainActivity.this).nightMode = isNight;
                ThemeSettings.getInstance(MainActivity.this).refreshTheme();
            }
        });

        dayNightSwitch.setAnimListener(new DayNightSwitchAnimListener() {
            @Override
            public void onAnimEnd() {
                Intent intent = new Intent(MainActivity.this, MainActivity.this.getClass());
                intent.putExtras(getIntent());
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                finish();
            }
            @Override
            public void onAnimValueChanged(float v) {

            }
            @Override
            public void onAnimStart() {
            }
        });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        ThemeSettings.getInstance(this).save(this);
    }
    @Override
    protected void onResume() {
        super.onResume();
    }

}
