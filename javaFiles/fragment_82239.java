public void fieldChanged(Field f, int c) {
    if (f == myConnectButton) {
        connect(...);
    }
}

private class MyBluetoothConnectionListener ... {
    public void deviceConnected(boolean success) {
        if (success) {
            bluetoothConnectionEstablished();
        } else {
            bluetoothConnectionFailed();
        }
    }
}

private void bluetoothConnectionEstablished() {
    // TODO - put your logic here for what to do when the connection succeeds
}

private void bluetoothConnectionFailed() {
    // TODO - put your logic here for what to do when the connection fails
}