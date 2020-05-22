private final BroadcastReceiver receiver = new BroadcastReceiver(){
    @Override
    public void onReceive(Context context, Intent intent) {

        String action = intent.getAction();
        if(BluetoothDevice.ACTION_FOUND.equals(action)) {
            int  rssi = intent.getShortExtra(BluetoothDevice.EXTRA_RSSI,Short.MIN_VALUE);
            Toast.makeText(getApplicationContext(),"  RSSI: " + rssi + "dBm", Toast.LENGTH_SHORT).show();
        }
    }
};