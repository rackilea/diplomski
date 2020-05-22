@Override
    public void onConnected(Bundle bundle) {
        mIntentService = new Intent(this, LocationService.class);

        // could be any object
        EventBus.getDefault().postSticky(database);
        ...
        mPendingIntent = PendingIntent.getService(this, 1, mIntentService, 0);

}