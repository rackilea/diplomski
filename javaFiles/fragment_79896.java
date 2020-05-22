LocationManager locationManager = null;

protected void onCreate(Bundle savedInstanceState) {
    ...
    locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
    ...
}