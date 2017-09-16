package com.example.user.mylifemap;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
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
            myLocationListener = new MyLocationListener();

            if (LocationManager.NETWORK_PROVIDER != null) {
                /**
                 * NETWORK_PROVIDER WiFi 엑세스 포인트의 가용성에 따라 위치를 결정
                 */
                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, minTime, minDistance, myLocationListener);
                Log.i(LOG_TAG, "NETWORK_PROVIDER not NULL");
            }
            else{
                /**
                 * GPS_PROVIDER 위성을 사용하여 위치를 결정 조건에 따라 위치 정보를 반환하는데 약간의 시간이 걸릴 수 있음.
                 */
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, minTime, minDistance, myLocationListener);
                Log.i(LOG_TAG, "NETWORK_PROVIDER NULL");
            }
        } catch (SecurityException e) {
            e.printStackTrace();
        }

    }

    private static class MyLocationListener implements LocationListener {

        @Override
        public void onLocationChanged(Location location) {
            double latitude = location.getLatitude();
            double longitude = location.getLongitude();

            Log.i("위도", String.valueOf(latitude));
            Log.i("경도", String.valueOf(longitude));
            System.out.println();
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        //사용 불가능 할시 메소드 호출
        @Override
        public void onProviderDisabled(String provider) {

        }
    }
}
