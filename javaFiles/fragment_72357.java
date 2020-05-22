// location callback - get location updates here:
LocationCallback mLocationCallback = new LocationCallback() {
    @Override
    public void onLocationResult(LocationResult locationResult) {
        Log.d("MainActivity", "onLocationResult triggered!");

            mCurrentLocation = locationResult.getLastLocation();
            Log.d("MainActivity", "Lat: " + mCurrentLocation.getLatitude() + ", Long: " + mCurrentLocation.getLongitude());
            // write current location to geofire:
            geofire.setLocation(mCurrentUserID, new GeoLocation(mCurrentLocation.getLatitude(), mCurrentLocation.getLongitude()), new GeoFire.CompletionListener() {
                @Override
                public void onComplete(String key, DatabaseError error) {
                    if (error != null) {
                        Log.d("MainActivity", "There was an error saving the location to GeoFire: " + error);
                    } else {
                        Log.d("MainActivity", "Location saved on server successfully!");
                        // check current user sex:
                        checkSex();

                        // find nearby users of the current user's location:
                        getNearbyUsers();
                    }
                }
            }

    }
};