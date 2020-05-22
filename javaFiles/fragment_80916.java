`@Override`
    public void onResult(LocationSettingsResult locationSettingsResult) {

    final Status status = locationSettingsResult.getStatus();

    switch (status.getStatusCode()) {
        case LocationSettingsStatusCodes.SUCCESS:
            if (!(ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) ==
                    PackageManager.PERMISSION_GRANTED &&
                    ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) ==
                            PackageManager.PERMISSION_GRANTED)) {

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
                        222);
            }
            else
            {
                getPhoneLocation();
            }
            // All location settings are satisfied. The client can
            // initialize location requests here.
            break;
        case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:
            // Location settings are not satisfied, but this can be fixed
            // by showing the user a dialog.
            try {
                // Show the dialog by calling startResolutionForResult(),
                // and check the result in onActivityResult().
                status.startResolutionForResult(
                        MainActivity.this,
                        111);
            } catch (IntentSender.SendIntentException e) {
                // Ignore the error.
            }
            break;
        case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
            // Location settings are not satisfied. However, we have no way
            // to fix the settings so we won't show the dialog.
            break;
    }
}