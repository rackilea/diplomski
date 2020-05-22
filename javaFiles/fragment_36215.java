private BroadcastReceiver mWifiStateChangeReceiver = new BroadcastReceiver() {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                if (action.equalsIgnoreCase(WifiManager.WIFI_STATE_CHANGED_ACTION)) {
                    ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
                    if (connectivityManager != null) {
                        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
                        if (networkInfo != null) {
                            // just to be more sure, you can also check whether the connected APN as same as the required one
                            // by comparing APN names
                            if (networkInfo.getDetailedState() == NetworkInfo.DetailedState.CONNECTED) {
                                Intent i = new Intent(context, secondActivity.class);                        
                                startActivity(i);
                            }
                        }
                    }
                }
            }
        }
    }
};