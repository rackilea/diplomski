public class NetworkChangeReceiver extends BroadcastReceiver {

      @Override
public void onReceive(final Context context, final Intent intent) {

    final ConnectivityManager connMgr = (ConnectivityManager) context
            .getSystemService(Context.CONNECTIVITY_SERVICE);

    final NetworkInfo wifi = connMgr
            .getNetworkInfo(ConnectivityManager.TYPE_WIFI);

    NetworkInfo activeNetwork = cm.getActiveNetworkInfo(); 

    boolean isConnected = wifi != null &&   
                wifi.isConnected() ;

    if (isConnected ) {
        // Do something

        Log.d("Netowk Available ", "Flag No 1");
    }else {
       Log.d("Netowk not available  Available ", "Flag No 2");

     }
  }
}