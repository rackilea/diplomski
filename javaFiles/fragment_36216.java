@Override
protected void onStart() {
    super.onStart();
    IntentFilter intentFilter = new IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION);
    this.registerReceiver(mWifiStateChangeReceiver, intentFilter);
}

@Override
protected void onStop() {
    super.onStop();
    this.unregisterReceiver(mWifiStateChangeReceiver);
}