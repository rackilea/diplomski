LocationRequest mLocationRequest = new LocationRequest();
    mLocationRequest.setInterval(30000);
    mLocationRequest.setFastestInterval(10000);
    mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

    LocationCallback mLocationCallback = new LocationCallback();



// Register the listener with the Location Manager to receive location updates
    try {
        mFusedLocationClient.requestLocationUpdates(mLocationRequest,
                mLocationCallback,
                null /* Looper */);

    }
    catch (SecurityException e) {
        // lets the user know there is a problem with the gps
    }