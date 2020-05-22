@Override
protected void onDestroy() {
    // Unregister since the activity is about to be closed.
    LocalBroadcastManager.getInstance(this).unregisterReceiver(receiver);
    super.onDestroy();
}