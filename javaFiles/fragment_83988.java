@Override
protected void onResume() {
    super.onResume();
    Intent intent = getIntent();
    if (intent.hasExtra("NOTIFICATION_PACKET")) {
        Log.e(TAG, "The following data was received from the notification packet: " + getIntent().getStringExtra("NOTIFICATION_PACKET"));
        getIntent().removeExtra("NOTIFICATION_PACKET");
    }
}