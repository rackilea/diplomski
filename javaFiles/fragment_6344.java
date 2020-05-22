@Override
protected void onResume() {
    super.onResume();
    LocalBroadcastManager.getInstance(this).registerReceiver(receiver,
            new IntentFilter(SMSReceiver.NOTIFICATION));
}