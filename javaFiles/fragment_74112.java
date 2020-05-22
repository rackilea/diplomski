public void getCurrentLocationUpdates(final UserLocationCallback callback){
        if (mIsReceivingUpdates){
            callback.onFailedRequest("Device is already receiving updates");
            return;
        }

        // Set up the LocationCallback for the request
        mLocationCallback = new LocationCallback()
        {
            @Override
            public void onLocationResult(LocationResult locationResult){
                if (locationResult != null){
                    callback.onLocationResult(locationResult.getLastLocation());
                } else {
                    callback.onFailedRequest("Location request returned null");
                }
            }
        };

        // Start the request
        mLocationClient.requestLocationUpdates(mLocationRequest, mLocationCallback, null);
        // Update the request state flag
        mIsReceivingUpdates = true;
    }