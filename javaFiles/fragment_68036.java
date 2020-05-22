@Override
public void onCreate(Bundle savedInstanceState) {

  ...

  // Register to receive data.
  // with actions named "my-event".
  LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver,
      new IntentFilter("my-event"));
}