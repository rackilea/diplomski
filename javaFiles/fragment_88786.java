wifiManager = (WifiManager) this.getSystemService(Context.WIFI_SERVICE); 

boolean wifiEnabled = wifiManager.isWifiEnabled();
if(!wifiEnabled){
    wifiManager.setWifiEnabled(true);
}