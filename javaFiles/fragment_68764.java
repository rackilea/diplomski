private static final int PERMISSION_REQUEST_FINE_LOCATION = 1;

private void getLocationRequest() {
    FusedLocationProviderClient client = LocationServices.getFusedLocationProviderClient(this);
    if (!checkPermission()) {
        getLocationPermissions();
        return;
    }
    client.getLastLocation()
            .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {
                    // Got last known location. In some rare situations this can be null.
                    if (location != null) {
                        // Logic to handle location object
                        Log.e("TAG", "location = " + location);
                    } else {
                        Log.e("TAG", "not successful");
                    }
                }
            });
}

private boolean checkPermission() {
    return isGranted(ActivityCompat.checkSelfPermission(this, ACCESS_FINE_LOCATION)) &&
            isGranted(ActivityCompat.checkSelfPermission(this, ACCESS_COARSE_LOCATION));
}

@TargetApi(Build.VERSION_CODES.M)
private void getLocationPermissions() {
    requestPermissions(new String[] {Manifest.permission.ACCESS_FINE_LOCATION},
            PERMISSION_REQUEST_FINE_LOCATION);
}

@Override
public void onRequestPermissionsResult(int code, @Nullable String permissions[], @Nullable int[] results) {
    switch (code) {
        case PERMISSION_REQUEST_FINE_LOCATION:
            if (isPermissionGranted(results)) {
                getLocationRequest();
            }
    }
}

private boolean isPermissionGranted(int[] results) {
    return results != null && results.length > 0 && isGranted(results[0]);
}

private boolean isGranted(int permission) {
    return permission == PackageManager.PERMISSION_GRANTED;
}