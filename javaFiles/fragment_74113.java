public void stopLocationUpdates(){

    mLocationClient.removeLocationUpdates(mLocationCallback);
    mIsReceivingUpdates = false;
    Log.i(TAG, "Location updates removed");

}