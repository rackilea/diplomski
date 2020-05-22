@Override
public void onCreate() {
    super.onCreate();

    locationManager = (LocationManager) getApplicationContext()
        .getSystemService(Context.LOCATION_SERVICE);

    Location lastKnownLocation = locationManager
        .getLastKnownLocation(Locat‌​ionManager.GPS_PROVI‌​DER); 

    // Check everytime this value, it may be null
    if(lastKnownLocation != null){
        double latitude = lastKnownLocation.getLatitude();
        double longitude = lastKnownLocation.getLongitude();
        // Use values as you wish
    }

    broadcastLocation("0","0");


    ....
}