BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

    // if device does not support Bluetooth
    if(mBluetoothAdapter==null){
        Log.d(TAG,"device does not support bluetooth");
        return null;
    }

    return mBluetoothAdapter.getAddress();