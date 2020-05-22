mGoogleApiClient = new GoogleApiClient.Builder(this)
            .addConnectionCallbacks(this)
            .addOnConnectionFailedListener(this)
            .addApi(LocationServices.API).build();

 mLastLocation = LocationServices.FusedLocationApi
            .getLastLocation(mGoogleApiClient);