@Override
protected void onResume() {
    super.onResume();
    IntentFilter filter = new IntentFilter();
    filter.addAction("com.example.MainActivity");   
    exampleBroadcastReceiver = new ExampleBroadcastReceiver();
    LocalBroadcastManager.getInstance(this).registerReceiver(exampleBroadcastReceiver, filter);
}