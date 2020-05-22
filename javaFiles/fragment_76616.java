@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // Register for reciever
    IntentFilter filter = new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
    registerReceiver(mReceiver, filter);
}

@Override
public void onDestroy() {
    super.onDestroy();

    // Unregister broadcast listeners
    unregisterReceiver(mReceiver);
}