public static final byte NO_ALERT = 0x00; //your byte data
public final static UUID IMMEDIATE_ALERT_UUID =
        UUID.fromString("00001802-0000-1000-8000-00805f9b34fb"); //UUID of gatt service
public final static UUID IMMEDIATE_ALERT_LEVEL_UUID =
        UUID.fromString("00002a06-0000-1000-8000-00805f9b34fb"); //UUID of characteristic

@Override
public void onCharacteristicWrite(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status) {

   byte[] data;
   byte b = NO_ALERT;
   data = new byte[]{b};
   BluetoothGattService service = gatt.getService(IMMEDIATE_ALERT_UUID);
   if (service != null) {
       BluetoothGattCharacteristic characteristic = service.getCharacteristic(IMMEDIATE_ALERT_LEVEL_UUID);
       characteristic.setValue(data);
       gatt.writeCharacteristic(characteristic);
   }
}