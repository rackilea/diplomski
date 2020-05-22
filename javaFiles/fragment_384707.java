public static final BluetoothGattCallback readGattCallback = new BluetoothGattCallback() {

    List<BluetoothGattCharacteristic> chars = new ArrayList<>();

    @Override
    public void onConnectionStateChange(BluetoothGatt gatt, int status, int newState) {

        if (newState == BluetoothProfile.STATE_CONNECTED) {
            Log.v(TAG, "Connected!");
            broadcastingInterval = 999;
            transmissionPower = 999;
            gatt.discoverServices();
        }
        if (newState == BluetoothProfile.STATE_DISCONNECTED) {
            Log.v(TAG, "Disconnected...");

        }
    }

    @Override
    public void onServicesDiscovered(BluetoothGatt gatt, int status) {

        List<BluetoothGattService> services = gatt.getServices();
        BluetoothGattService rightService = null;

        for (int i = 0; i < services.size(); i++) {
            if (services.get(i).getCharacteristics().size() > 8) {
                rightService = services.get(i);
            }
        }

        chars.add(rightService.getCharacteristics().get(4));
        chars.add(rightService.getCharacteristics().get(6));

        requestCharacteristics(gatt);

    }

    public void requestCharacteristics(BluetoothGatt gatt) {
        gatt.readCharacteristic(chars.get(chars.size()-1));
    }

    @Override
    public void onCharacteristicRead(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status) {
        if (status == 0) {

            if (characteristic.getUuid().toString().substring(7, 8).equals("5")) {
                transmissionPower = characteristic.getIntValue(BluetoothGattCharacteristic.FORMAT_UINT8, 0);
                Log.v(TAG, "tPOWER READ");

            } else if (characteristic.getUuid().toString().substring(7,8).equals("7")) {
                broadcastingInterval = characteristic.getIntValue(BluetoothGattCharacteristic.FORMAT_UINT8, 0);
                Log.v(TAG, "INTERVAL READ");
            }

            chars.remove(chars.get(chars.size() - 1));

            if (chars.size() > 0) {
                requestCharacteristics(gatt);
            } else {
                gatt.disconnect();
            }
        }
    }

};