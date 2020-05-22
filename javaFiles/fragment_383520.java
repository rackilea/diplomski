// Loops through available GATT Services.
for (BluetoothGattService gattService : gattServices) {
    if (uuid.equals("THE NAME OF THE SERVICE THAT I WANT") {
        // and then call 
        mBluetoothLeService.setCharacteristicNotification(characteristic, true);
    }
}