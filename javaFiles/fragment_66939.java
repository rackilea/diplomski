public void returnData(String data) {
    BluetoothGattService service = bluetoothGatt.getService(SERVICE_UUID);
    BluetoothGattCharacteristic characteristic = service.getCharacteristic(CHARACTERISTIC_UUID);
    String dataString = data;
    dataString.getBytes();
    writeCharacteristic.setValue(dataString);
    writeCharacteristic.setWriteType(BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE);
    bluetoothGatt.writeCharacteristic(writeCharacteristic);
}