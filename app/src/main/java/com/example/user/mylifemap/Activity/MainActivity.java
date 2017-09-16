package com.example.user.mylifemap.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.user.mylifemap.ActivityDesigner;
import com.example.user.mylifemap.Gps.MyLocation;
import com.example.user.mylifemap.R;
import com.nhn.android.maps.NMapView;
import com.nhn.android.maps.maplib.NGeoPoint;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;

//
public class MainActivity extends AppCompatActivity {
    private NGeoPoint nGeoPoint;
    private NMapView nMapView;
    private final String CLIENT_ID = "YEB53plPBT8yuSKR_NuA";

    private MyLocation myLocation;

    private String LOG_TAG = "MainActivity";

    private final int REGISTER_REQUEST = 1;
    private final int SEARCH_REQUEST = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        myLocation = new MyLocation(this);
    }

    @Optional @OnClick(R.id.registerMyLife) void registerMyLifeButtonClick(){
        Intent intent = new Intent(this, RegisterMyLifeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivityForResult(intent, REGISTER_REQUEST);
    }

    @Optional @OnClick(R.id.searchMyLife) void searchMyLifeButtonClick(){
        Toast.makeText(getApplicationContext(), "나의 인생 검색 버튼 클릭", Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onResume() {
        super.onResume();
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.mainActionbarTitle));
        ActivityDesigner activityDesigner = new ActivityDesigner(this, actionBar);
        activityDesigner.initalSettingforActivityDesign();
    }
}
