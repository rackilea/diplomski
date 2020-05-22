@Override
protected void onResume() {
    super.onResume();
    if (!mGoogleApiClient.isConnected()) {
        mGoogleApiClient.connect();
    }   
}

@Override
public void onConnected(Bundle bundle) {
    resumeLocationUpdates();
}