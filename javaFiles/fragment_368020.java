BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
    @Override
    public void onReceive(Context context, Intent intent) {
        //RESTART APPLICATION
    }
 };

//register broadcastreceiver
LocalBroadcastManager.getInstance(getContext())
    .registerReceiver(mBroadcastReceiver, new IntentFilter(Intent.ACTION_LOCALE_CHANGED));

//remember to unregister in onDestroy with LocalBroadcastManager.getInstance(mContext).unregisterReceiver(mBroadcastReceiver);