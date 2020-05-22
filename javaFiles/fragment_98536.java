requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 10, new LocationListener(){  
    @Override 
    public void onLocationChanged(Location location){
        Log.d("LOCATION", location.toString());
    }
});