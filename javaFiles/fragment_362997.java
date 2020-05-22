@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    /* ... */

    // Register for broadcasts on BluetoothAdapter state change
    IntentFilter filter = new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
    registerReceiver(mReceiver, filter);
}

@Override
public void onDestroy() {
    super.onDestroy();

    /* ... */

    // Unregister broadcast listeners
    unregisterReceiver(mReceiver);
}