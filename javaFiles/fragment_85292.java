protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this) //this = activity
                .addApi(LocationServices.API)
                .addConnectionCallbacks(this) //interfaces implemented
                .addOnConnectionFailedListener(this)
                .build();
    }