@Override
    public void onConnectionStateChange(BluetoothGatt gatt, int status,
            int newState) {

        BluetoothDevice device = gatt.getDevice();
        String address = device.getAddress();

        if (newState == BluetoothProfile.STATE_CONNECTED) {

            Log.i(TAG, "Connected to GATT server.");

            if (!connectedDeviceMap.containsKey(address)) {
                  connectedDeviceMap.put(address, gatt);
              }
             // Broadcast if needed
            Log.i(TAG, "Attempting to start service discovery:" +
                    gatt.discoverServices());

        } else if (newState == BluetoothProfile.STATE_DISCONNECTED) {
            Log.i(TAG, "Disconnected from GATT server.");
            if (connectedDeviceMap.containsKey(address)){
              BluetoothGatt bluetoothGatt = connectedDeviceMap.get(address);
              if( bluetoothGatt != null ){
                   bluetoothGatt.close();
                   bluetoothGatt = null;
              } 
              connectedDeviceMap.remove(address);                
            }
            // Broadcast if needed
        }
    }