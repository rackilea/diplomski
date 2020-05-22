@Override
public void onResult(LocationSettingsResult locationSettingsResult) {
    final Status status = locationSettingsResult.getStatus();
    switch (status.getStatusCode()) {
        case LocationSettingsStatusCodes.SUCCESS:
            // All location settings are satisfied. The client can
            // initialize location requests here.
            Log.i(TAG, "All location settings are satisfied.");
            startLocationUpdates();
            break;
        case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:
            // Location settings are not satisfied, but this can be fixed
            // by showing the user a dialog.
            Log.i(TAG, "Location settings are not satisfied. Show the user a dialog to " +
                    "upgrade location settings ");
            try {
                // Show the dialog by calling startResolutionForResult(),
                // and check the result in onActivityResult().
                status.startResolutionForResult(MainActivity.getInstance(), REQUEST_CHECK_SETTINGS);
            } catch (IntentSender.SendIntentException e) {
                // Ignore the error.
                Log.i(TAG, "PendingIntent unable to execute request.");
            }
            break;
        // The status will never be SETTINGS_CHANGE_UNAVAILABLE if use builder.setAlwaysShow(true);
        case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
            // Location settings are not satisfied. However, we have no way
            // to fix the settings so we won't show the dialog.
            Log.i(TAG, "Location settings are inadequate, and cannot be fixed here. Dialog " +
                    "not created.");
            break;
    }
}