public boolean ToggleHotspot(boolean ON_OFF)
{



    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
    {


        if (!Settings.System.canWrite(mContext))
        {
            Intent writeSettingIntent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS);

          // Works when calling directly from MainActivity.java,but not from Android Library.WHY??
          // writeSettingIntent.setData(Uri.parse("package: " + mContext.getPackageName()));
            writeSettingIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            mContext.startActivity(writeSettingIntent);
        }
    }
        //TODO -> Check if hotspot enabled.If not start it...
         WifiManager wifiMgr = (WifiManager) mContext.getSystemService(Context.WIFI_SERVICE);
                try{

                    if(this.isWiFiEnabled())
                    {
                        this.DisableWiFi();
                    }

                    Method invokeMethod = wifiMgr.getClass().getMethod("setWifiApEnabled",WifiConfiguration.class,boolean.class);
                    return (Boolean)invokeMethod.invoke(wifiMgr,initHotspotConfig(),ON_OFF);
                }
                catch(Throwable ignoreException)
                {
                    return false;
                }


}




 private WifiConfiguration initHotspotConfig(){

     WifiConfiguration wifiConfig = new WifiConfiguration();

      wifiConfig.SSID = "Test Hotspot";
     // must be 8 length
      wifiConfig.preSharedKey = "abcd1234";

      wifiConfig.hiddenSSID = true;


     wifiConfig.status = WifiConfiguration.Status.ENABLED;
     wifiConfig.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.TKIP);
     wifiConfig.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.CCMP);
     wifiConfig.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.WPA_PSK);
     wifiConfig.allowedPairwiseCiphers.set(WifiConfiguration.PairwiseCipher.TKIP);
     wifiConfig.allowedPairwiseCiphers.set(WifiConfiguration.PairwiseCipher.CCMP);
     wifiConfig.allowedProtocols.set(WifiConfiguration.Protocol.RSN);


    return wifiConfig;
 }