private void sendMessage(String message) {
    // Check that we're actually connected before trying anything
    if (bluetoothConnectionService.getState() != BluetoothConnectionService.STATE_CONNECTED) {
        Toast.makeText(MainActivity.this, R.string.not_connected, Toast.LENGTH_SHORT).show();
        return;
    }

    // Check that there's actually something to send
    if (message.length() > 0) {
        // Get the message bytes and tell the BluetoothConnectionService to write
        byte[] send = message.getBytes();
        bluetoothConnectionService.write(send);

        // Reset out string buffer to zero and clear the edit text field
        mOutStringBuffer.setLength(0);
    }
}