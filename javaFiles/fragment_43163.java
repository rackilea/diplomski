public class NetworkChangeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //here, check that the network connection is available. If yes, start your email service. If not, stop your email service.
       ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
       NetworkInfo info = cm.getActiveNetworkInfo();
       if (info != null) {
           if (info.isConnected()) {
               //start service
               Intent intent = new Intent(this, ItemServiceManager.class);
               startService(intent);
           }
           else {
               //stop service
               Intent intent = new Intent(this, ItemServiceManager.class);
               stopService(intent);
           }
       }
    }
}