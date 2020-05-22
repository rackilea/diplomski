@Override
public void onCreate(Bundle savedInstanceState) {
...
    locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
// Instead of: 
// LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
...
}