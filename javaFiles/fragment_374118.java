public void FindLocation(Context context){
    final LocationManager locationManager (LocationManager)context.getSystemService(Context.LOCATION_SERVICE);
    LocationListener locationListener = new LocationListener(){
        public void onLocationChanged(Location location){
            updateLocation(location);
            locationManager.removeUpdates(this);
        }
        public void onStatusChanged(String provider, int status, Bundle extras) {}
        public void onProviderEnabled(String provider) {}
        public void onProviderDisabled(String provider) {}
    };
    locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
}