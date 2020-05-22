boolean onRightNetwork() {
    WifiManager wifiManager = (WifiManager) App.getContext()
                        .getSystemService(App.getContext().WIFI_SERVICE);
                WifiInfo wifiInfo = wifiManager.getConnectionInfo();

    return wifiInfo.getSSID().equals(NETWORK_NAME);
}