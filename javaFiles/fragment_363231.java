public  void startPingService(Context context)
{
  List<LocalDeviceInfo> deviceInfoList  = new ArrayList<LocalDeviceInfo>();
    try {

        WifiManager mWifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        WifiInfo mWifiInfo = mWifiManager.getConnectionInfo();
        String subnet = getSubnetAddress(mWifiManager.getDhcpInfo().gateway);


        for (int i=1;i<255;i++){

            String host = subnet + "." + i;

            if (InetAddress.getByName(host).isReachable(timeout)){

                String strMacAddress = getMacAddressFromIP(host);

                Log.w("DeviceDiscovery", "Reachable Host: " + String.valueOf(host) +" and Mac : "+strMacAddress+" is reachable!");

                    LocalDeviceInfo localDeviceInfo = new LocalDeviceInfo(host,strMacAddress);
                    deviceInfoList.add(localDeviceInfo);
             }
            else
            {
                Log.e("DeviceDiscovery", "❌ Not Reachable Host: " + String.valueOf(host));

            }
        }


    }
    catch(Exception e){
        //System.out.println(e);
    }


}


private String getSubnetAddress(int address)
{
    String ipString = String.format(
            "%d.%d.%d",
            (address & 0xff),
            (address >> 8 & 0xff),
            (address >> 16 & 0xff));

    return ipString;
}