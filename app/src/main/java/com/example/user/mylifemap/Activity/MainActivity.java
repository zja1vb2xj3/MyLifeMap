package com.example.user.mylifemap.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.user.mylifemap.ActivityDesigner;
import com.example.user.mylifemap.ConstantManager;
import com.example.user.mylifemap.Gps.MyLocation;
import com.example.user.mylifemap.R;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;

//
public class MainActivity extends AppCompatActivity {

    private final String LOG_TAG = "MainActivityLog";
    private MyLocation myLocation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        myLocation = new MyLocation(this);
        myLocation.updateMyLocation();
    }

    @Optional @OnClick(R.id.registerMyLife)
    void registerMyLifeButtonClick(){
        Log.i(LOG_TAG, String.valueOf(myLocation.getLatitude()));
        Log.i(LOG_TAG, String.valueOf(myLocation.getLongitude()));

        Intent intent = new Intent(this, RegisterMyLifeActivity.class);

        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra(ConstantManager.LATITUDE_KEY, myLocation.getLatitude());
        intent.putExtra(ConstantManager.LONGITUTE_KEY, myLocation.getLongitude());

        startActivity(intent);
    }

    @Optional @OnClick(R.id.searchMyLife)
    void searchMyLifeButtonClick(){
        Toast.makeText(getApplicationContext(), "나의 인생 검색 버튼 클릭", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        myLocation.updateMyLocation();
    }

    @Override
    protected void onResume() {
        super.onResume();
        myLocation.updateMyLocation();
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.mainActionbarTitle));
        ActivityDesigner activityDesigner = new ActivityDesigner(this, actionBar);
        activityDesigner.initalSettingforActivityDesign();
    }
}
