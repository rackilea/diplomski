private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
    @Override
    public void onReceive(Context context, Intent intent) {
        final String action = intent.getAction();

        if (action.equals(BluetoothAdapter.ACTION_STATE_CHANGED)) {
            final int state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE,
                                                 BluetoothAdapter.ERROR);
            switch (state) {
            case BluetoothAdapter.STATE_OFF:
                setButtonText("Bluetooth off");
                break;
            case BluetoothAdapter.STATE_TURNING_OFF:
                setButtonText("Turning Bluetooth off...");
                break;
            case BluetoothAdapter.STATE_ON:
                setButtonText("Bluetooth on");
                break;
            case BluetoothAdapter.STATE_TURNING_ON:
                setButtonText("Turning Bluetooth on...");
                break;
            }
        }
    }
};