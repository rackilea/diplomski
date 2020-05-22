@Override
public void onStart() {
    super.onStart();
    LocalBroadcastManager.getInstance(activity).registerReceiver(mMessageReceiver,
            new IntentFilter("subscription_state"));
    activity.queryPurchases();
    Log.d("receiver", "Receiver created " + TAG);

}

private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
    @Override
    public void onReceive(Context context, Intent intent) {
        // if subscription state is true, load subscribe screens
        if (mMonthlySubscribed)
            activity.loadFragment(new SubscriptionFragment());
        Log.d("receiver", "Subscription state update received " + TAG);
    }
};