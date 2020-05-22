public class Connect extends AsyncTask<String, Void, Boolean> {

private Activity activity;
private Context context;

public LoadContacts(Activity activity){
    this.activity=activity;
    context = activity;
}

@Override
protected void onPreExecute() {
    // TODO Auto-generated method stub
    super.onPreExecute();

}

@Override
protected void onPostExecute(Boolean result) {
    TextView tv= (TextView) activity.findViewById(R.id.tv); 
    if (connec != null && (connec.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTED) ||(connec.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTED)){  

         tv.setText("You are now connected!  " +  "Version 1.1"); 
        }else if (connec.getNetworkInfo(0).getState() == NetworkInfo.State.DISCONNECTED ||  connec.getNetworkInfo(1).getState() == NetworkInfo.State.DISCONNECTED ) {              

            tv.setText("The was an error connecting, please try again."); 
        }
    super.onPostExecute();
}

@Override
protected Boolean doInBackground(String... params) {
    WifiManager wifi = (WifiManager) activity.getSystemService(Context.WIFI_SERVICE); 
WifiConfiguration wc = new WifiConfiguration();  
wc.SSID = "\"Test\""; //IMP! This should be in Quotes!! 

wc.hiddenSSID = true; 
wc.status = WifiConfiguration.Status.ENABLED;      
wc.priority = 10; 
wc.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.WPA_PSK); 
wc.allowedProtocols.set(WifiConfiguration.Protocol.RSN);  
wc.allowedProtocols.set(WifiConfiguration.Protocol.WPA); 
wc.allowedAuthAlgorithms.set(WifiConfiguration.AuthAlgorithm.OPEN); 
wc.allowedAuthAlgorithms.set(WifiConfiguration.AuthAlgorithm.SHARED); 
wc.allowedPairwiseCiphers.set(WifiConfiguration.PairwiseCipher.CCMP); 
wc.allowedPairwiseCiphers.set(WifiConfiguration.PairwiseCipher.TKIP); 
wc.preSharedKey = "\"Password\""; 
WifiManager  wifiManag = (WifiManager) context.getSystemService(WIFI_SERVICE); 
boolean res1 = wifiManag.setWifiEnabled(true); 
int res = wifi.addNetwork(checkPreviousConfiguration(wc)); 
Log.d("WifiPreference", "add Network returned " + res ); 
boolean es = wifi.saveConfiguration(); 
Log.d("WifiPreference", "saveConfiguration returned " + es ); 
boolean b = wifi.enableNetwork(res, true);    
Log.d("WifiPreference", "enableNetwork returned " + b );   



     ConnectivityManager connec = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE); 

    return true;
}

}