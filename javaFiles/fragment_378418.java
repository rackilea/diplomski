if (intent.getAction().equals(WifiManager.NETWORK_STATE_CHANGED_ACTION)){
  elapseTime = System.currentTimeMillis() - startTime;
  WifiInfo wifiInfo = wifiManager.getConnectionInfo();
  int ipAddress = wifiInfo.getIpAddress();
  if (ipAddress != 0 && !wifiConnected) {
    wifiConnected = true;
    wifiTimeLog = wifiTimeLog + elapseTime + "," + "DHCP Done" + "\n";
    state.setText(wifiTimeLog);
 }