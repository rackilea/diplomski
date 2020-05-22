protected void getLocation() {
    if (isLocationEnabled(MainActivity.this)) {
        locationManager = (LocationManager)  this.getSystemService(Context.LOCATION_SERVICE);
        criteria = new Criteria();
        bestProvider = String.valueOf(locationManager.getBestProvider(criteria, true)).toString();

        //You can still do this if you like, you might get lucky:
        Location location = locationManager.getLastKnownLocation(bestProvider);
        if (location != null) {
            Log.e("TAG", "GPS is on");
            latitude = location.getLatitude();
            longitude = location.getLongitude();
            Toast.makeText(MainActivity.this, "latitude:" + latitude + " longitude:" + longitude, Toast.LENGTH_SHORT).show();
            searchNearestPlace(voice2text);
        }
        else{
            //This is what you need:
            locationManager.requestLocationUpdates(bestProvider, 1000, 0, this);
        }
    }
    else
    {
        //prompt user to enable location....
        //.................
    }
}