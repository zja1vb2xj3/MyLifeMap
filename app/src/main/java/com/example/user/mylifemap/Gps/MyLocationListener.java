package com.example.user.mylifemap.Gps;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

/**
 * Created by user on 2017-09-16.
 */

public class MyLocationListener implements LocationListener {
    private double latitude;
    private double longitude;



    @Override
    public void onLocationChanged(Location location) {
        latitude = location.getLatitude();
        longitude = location.getLongitude();

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
