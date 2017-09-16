package com.example.user.mylifemap.Activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.example.user.mylifemap.ActivityDesigner;
import com.example.user.mylifemap.R;

public class RegisterMyLifeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_my_life);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.registerActionbarTitle));
        ActivityDesigner activityDesigner = new ActivityDesigner(this, actionBar);
        activityDesigner.initalSettingforActivityDesign();
    }
}
