@Override
public void onMapReady(GoogleMap googleMap) {
    mGoogleMap = googleMap;

    if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        int locationPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
        if (locationPermission == PackageManager.PERMISSION_GRANTED) {
            myLocationBottomLeftAlign();
        } else {
            // request permission and than call myLocationBottomLeftAlign();

        }
    } else {
        myLocationBottomLeftAlign();
    }
}