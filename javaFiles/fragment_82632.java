@Override
public int onStartCommand(Intent intent, int flags, int startId) {


Log.e(TAG,"Start");


mGoogleApiClient = new GoogleApiClient.Builder(this)
        .addConnectionCallbacks(this)
        .addOnConnectionFailedListener(this)
        .addApi(ActivityRecognition.API)
        .addApi(LocationServices.API)
        .build();

  if (!mGoogleApiClient.isConnected()) {
    Log.e(TAG,"GoogleApiClient not yet connected");

    mGoogleApiClient.connect(); // connect it here..

  } else {
    Log.e(TAG,"GoogleApiClient connected");

}

return Service.START_STICKY;

}