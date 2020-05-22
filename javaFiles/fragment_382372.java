@Override
public void onCreate(Bundle savedInstanceState) {
  LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver,
       new IntentFilter("custom-event-name"));
}

private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
  @Override
  public void onReceive(Context context, Intent intent) {
    String message = intent.getStringExtra("message");
 }
};