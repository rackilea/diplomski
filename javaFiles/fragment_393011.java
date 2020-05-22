LocationManager locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000, 10, new LocationListener() {
        @Override
        public void onStatusChanged(String s, int i, Bundle bundle) {}
        @Override
        public void onProviderEnabled(String s) {}
        @Override
        public void onProviderDisabled(String s) {}
        @Override
        public void onLocationChanged(final Location location) {}
    });
    Location myLocation = locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);
    double longitude = myLocation.getLongitude();
    double latitude = myLocation.getLatitude();
    message+="https://www.google.co.id/maps/@"+latitude+","+longitude;