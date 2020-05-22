package com.map.example;

import android.app.AlertDialog;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;

public class GPSTracker extends Service implements LocationListener{

private Context context;
boolean isGPSEnabled = false;
boolean isNetworkEnabled = false;
boolean canGetLocation = false;

Location location;
double latitude,longitude;

LocationManager locationManager;
AlertDialogManager am = new AlertDialogManager();
public GPSTracker(Context context){
    this.context = context;
    getLocation();
}
private Location getLocation() {
    // TODO Auto-generated method stub
    try{
        locationManager = (LocationManager)context.getSystemService(Context.LOCATION_SERVICE);

        isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);

        isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);


        if (!isGPSEnabled && !isNetworkEnabled){

        } else {
            this.canGetLocation = true;

            if (isNetworkEnabled){

                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 60000, 3, this);

                if (locationManager != null){
                    location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                    if (location != null){
                        latitude = location.getLatitude();
                        longitude = location.getLongitude();
                    }
                }
            }

            if (isGPSEnabled){
                if (location == null){
                    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 60000, 3, this);
                    if (locationManager != null){
                        location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                        if (location != null){
                            latitude = location.getLatitude();
                            longitude = location.getLongitude();
                        }
                    }
                }
            } else {
                showAlertDialog();
            }
        }
    }catch(Exception e){
        e.printStackTrace();
    }
    return location;
}


public void showAlertDialog(){
    am.showAlertDialog(GPSTracker.this, "GPS Setting", "Gps is not enabled. Do you want to enabled it ?", false);
}
public double getLatitude(){
    if (location != null){
        latitude = location.getLatitude();
    }

    return latitude;
}

public double getLongitude(){
    if (location != null){
        longitude = location.getLongitude();
    }

    return longitude;
}

public boolean canGetLocation(){
    return this.canGetLocation;
}
@Override
public void onLocationChanged(Location location) {
    // TODO Auto-generated method stub
    if (location != null){
        this.location = location;
    }
}

@Override
public void onProviderDisabled(String provider) {
    // TODO Auto-generated method stub

}

@Override
public void onProviderEnabled(String provider) {
    // TODO Auto-generated method stub

}

@Override
public void onStatusChanged(String provider, int status, Bundle extras) {
    // TODO Auto-generated method stub

}

@Override
public IBinder onBind(Intent intent) {
    // TODO Auto-generated method stub
    return null;
}

}