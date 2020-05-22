LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000L,1.0f, this);
    boolean isGPS = locationManager.isProviderEnabled (LocationManager.GPS_PROVIDER);

    if (isGPS){  
    // -------- IF GPS IS ENABLED, GET COORDINATES AND DISPLAY TO USER ------

        String locationProvider = LocationManager.GPS_PROVIDER;
        locationManager.requestLocationUpdates(locationProvider, 400, 1, this);

        Location loc =   locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

        if (loc != null)     // <---- This line can be included to avoid null pointer exception in case you are not able to get the coordinates.
        {
            viewlocation = (TextView) findViewById(R.id.location);
             viewlocation.setText("My Current location \n Latitude = "+ loc.getLatitude()+" \n Longitude = "+ loc.getLongitude());
       }

    }else{

    // --------IF GPS NOT ENABLED, THEN MOVE TO SETTINGS SCREEN TO HELP USER TO ENABLE GPS.
        startActivityForResult(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS), 0);
    }