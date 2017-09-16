package com.example.user.mylifemap.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.user.mylifemap.ActivityDesigner;
import com.example.user.mylifemap.ConstantManager;
import com.example.user.mylifemap.Gps.MyLocation;
import com.example.user.mylifemap.R;

public class RegisterMyLifeActivity extends AppCompatActivity {

    private final String LOG_TAG = "RegisterActivityLog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_my_life);
    }

    @Override
    protected void onStart() {
        super.onStart();
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.registerActionbarTitle));
        ActivityDesigner activityDesigner = new ActivityDesigner(this, actionBar);
        activityDesigner.initalSettingforActivityDesign();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (getIntent() != null) {
            double latitude = (double) getIntent().getExtras().get(ConstantManager.LATITUDE_KEY);
            double longitude = (double) getIntent().getExtras().get(ConstantManager.LONGITUTE_KEY);

            Log.i(LOG_TAG, String.valueOf(latitude));
            Log.i(LOG_TAG, String.valueOf(longitude));
        }
    }
}
