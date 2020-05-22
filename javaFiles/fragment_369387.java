public class TheBroadcastReceiver extends BroadcastReceiver 
{
    @Override
    public void onReceive(Context context, Intent intent) 
    {
        WifiManager wifiManager = (WifiManager) context
                .getSystemService(Context.WIFI_SERVICE);
        NetworkInfo datainfo = intent
                .getParcelableExtra(WifiManager.EXTRA_NETWORK_INFO);
        if (datainfo != null) 
        {
            if (datainfo.getType() == ConnectivityManager.TYPE_WIFI) 
            {
                //have different network states here
                if (datainfo.getState() == datainfo.State.CONNECTING || datainfo.getState() == datainfo.State.CONNECTED) {
                    //work accordingly
                }
            }
        }
    }
}