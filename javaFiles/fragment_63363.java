@Override
protected void onResume() {
    super.onResume();
    if (!mGoogleApiClient.isConnected()) {
        mGoogleApiClient.connect();
    }

    resumeLocationUpdates();

}
private void resumeLocationUpdates() {
    Log.i("RESUMING", "RESUMING LOCATION UPDATES");
    LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, locationRequest, this);
}