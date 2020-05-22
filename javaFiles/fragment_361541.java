BluetoothDevice device = mBluetoothAdapter.getRemoteDevice(deviceAddress);
  int connectionState = mBluetoothManager.getConnectionState(device, BluetoothProfile.GATT);

  if(connectionState == BluetoothProfile.STATE_DISCONNECTED ){
   // connect your device
   device.connectGatt(this, false, mGattCallbacks);
  }else if( connectionState == BluetoothProfile.STATE_CONNECTED ){
   // already connected . send Broadcast if needed
  }