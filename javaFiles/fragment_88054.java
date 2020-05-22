public string getValidSSID()
{
    List<ScanResult> results = wifiManager.getScanResults();
    HashMap<String,ScanResult> distinctNetworks = new HashMap<String, ScanResult>();
    for(ScanResult scanResult :  results)
    {
        if(scanResult.SSID.contains("Open"))
        {
            if(!distinctNetworks.containsKey(scanResult))
            {
                distinctNetworks.put(scanResult.SSID, scanResult); 
            }
            else
            {
                if(WifiManager.compareSignalLevel(scanResult.level, distinctNetworks.get(scanResult.SSID).level)>0)
                {
                    distinctNetworks.put(scanResult.SSID, scanResult);
                }
            }
        }
    }
    Set<String> networks  = distinctNetworks.keySet();// This will only contain one key which will be ths ssid with the max strength containing "open" in SSID
    for (String s : networks) {
        return s;
    }
}