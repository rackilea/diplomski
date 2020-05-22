@Override
 protected void onPause() {
     super.onPause();
     try {
         LocalBroadcastManager.getInstance(this).unregisterReceiver(exampleBroadcastReceiver);
     } catch (IllegalArgumentException e) {
    if (!e.getMessage().contains("Receiver not registered")) {
        // unexpected, re-throw
        throw e;

 }