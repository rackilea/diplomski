mWifiManager = (WifiManager)getSystemService(Context.WIFI_SERVICE);

//to listen to all network state changes (cell and wifi)
registerReceiver(mWifiScanReceiver, new IntentFilter(WifiManager.NETWORK_STATE_CHANGED_ACTION));

//to listen specifically to wifi changes
registerReceiver(mWifiScanReceiver, new IntentFilter(WifiManager.SUPPLICANT_CONNECTION_CHANGE_ACTION));