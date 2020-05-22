List<String> ids = new ArrayList<String>();
String essidPrefix = MainFragment.configuration.getEssidPrefix();
    wifiManager.startScan();
    results = wifiManager.getScanResults();
    bssid = ""; // this will reset it
    for(ScanResult scanResult : results){
        String scanWifi = scanResult.SSID;
       if(scanWifi.startsWith(essidPrefix)){
           // if you want to avoid null
           ids.add(scanResult.BSSID); // comma separate
       }
    }
   //bssid here only returns abc123
    return bssid = android.text.TextUtils.join(",", ids);