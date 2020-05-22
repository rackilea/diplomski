public int onStartCommand(Intent intent, int flags, final int startId) {

    String authenticationKey = ((MainApplication) getApplicationContext()).getDbConnector().getUserAuthDefault() ;
    // if user is not registered yet, stop this service, it may be called from boot reciever.
    if(authenticationKey == null){
        stopSelf();
    }

    // restart, if we get killed.
    return START_STICKY;
}