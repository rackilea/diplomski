@Override
    public void onConnected(Bundle bundle) {
    Log.e("Connection", "GOOGLE API Connected");


    LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder()
            .addLocationRequest(createLocationRequest());
    PendingResult<LocationSettingsResult> result =
            LocationServices.SettingsApi.checkLocationSettings(mGoogleApiClient,
                    builder.build());
    result.setResultCallback(this);

}