package com.example.user.mylifemap.Gps;

import android.content.Context;
import android.location.LocationManager;
import android.util.Log;


/**
 * Created by user on 2017-09-16.
 */

public class MyLocation {
    private Context context;
    private Double latitude;
    private Double longitude;
    private LocationManager locationManager;
    private MyLocationListener myLocationListener;
    private final String LOG_TAG = "MyLocation";

    public MyLocation(Context context) {
        this.context = context;
        locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
    }

    public void updateMyLocation() {
        final long minTime = 1;
        final float minDistance = 1;
        try {
            Log.i(LOG_TAG, "updateMyLocation");
            myLocationListener = new MyLocationListener();

            /**
             * NETWORK_PROVIDER WiFi 엑세스 포인트의 가용성에 따라 위치를 결정
             */
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, minTime, minDistance, myLocationListener);
            /**
             * GPS_PROVIDER 위성을 사용하여 위치를 결정 조건에 따라 위치 정보를 반환하는데 약간의 시간이 걸릴 수 있음.
             */
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, minTime, minDistance, myLocationListener);
        } catch (SecurityException e) {
            e.printStackTrace();
        }

    }

}//end MyLocation.class
