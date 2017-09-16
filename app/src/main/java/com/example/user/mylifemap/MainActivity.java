package com.example.user.mylifemap;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.nhn.android.maps.NMapLocationManager;
import com.nhn.android.maps.NMapView;
import com.nhn.android.maps.maplib.NGeoPoint;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private NGeoPoint nGeoPoint;
    private NMapView nMapView;
    private final String CLIENT_ID = "YEB53plPBT8yuSKR_NuA";

    private MyLocation myLocation;

    private Button button;

    private String LOG_TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.button1);
        button.setOnClickListener(v -> button1Click());
        myLocation = new MyLocation(this);
    }

    private void button1Click() {
        myLocation.updateMyLocation();
    }


    @Override
    protected void onResume() {
        super.onResume();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorBlack));//윈도우 색상 변경
            getSupportActionBar().setBackgroundDrawable(getDrawable(R.color.colorBlack));//액션바 색상 변경
        }
    }
}
