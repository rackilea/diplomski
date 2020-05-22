BluetoothDevice btDevice = bta.getRemoteDevice(macAddress);
BluetoothSocket btSocket = InsecureBluetooth.createRfcommSocketToServiceRecord(
                    btDevice, UUID.fromString("00001101-0000-1000-8000-00805F9B34FB"), false);

btSocket.connect();
InputStream input = btSocket.getInputStream();
DataInputStream dinput = new DataInputStream(input);