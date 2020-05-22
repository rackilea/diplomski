private final BroadcastReceiver mWifiScanReceiver = new BroadcastReceiver() {
    @Override
    public void onReceive(Context c, Intent intent) {
        if (intent.getAction() == WifiManager.NETWORK_STATE_CHANGED_ACTION) {
            Bundle extras = Intent.getExtras();
            NetworkInfo ni = extras.get(EXTRA_NETWORK_INFO);
            if (ni.getState() == State.CONNECTED) {
                //show button
            } else {
                //hide button
            }
        } else if (intent.getAction() == WifiManager.SUPPLICANT_CONNECTION_CHANGE_ACTION) {
            Bundle extras = Intent.getExtras();
            SupplicantState ss = extras.get(EXTRA_NEW_STATE);
            if (ss.getState() == COMPLETED) {
                //show button, note we may not have an IP address yet
            } else {
                //hide button
            }
            SupplicantState.COMPLETED
        }
    }
};