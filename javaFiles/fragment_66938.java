public void setNotifications() {
    BluetoothGattService service = bluetoothGatt.getService(SERVICE_UUID);
    BluetoothGattCharacteristic characteristic = service.getCharacteristic(CHARACTERISTIC_UUID);

    BluetoothGattDescriptor descriptor = characteristic.getDescriptor(DESCRIPTOR_UUID);
    descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
    characteristic.addDescriptor(descriptor);
    characteristic.setWriteType(BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE);
    bluetoothGatt.writeDescriptor(descriptor);

    bluetoothGatt.setCharacteristicNotification(characteristic, true);
}