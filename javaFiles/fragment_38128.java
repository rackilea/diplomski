try {
    PeripheralManager gpsmanager = PeripheralManager.getInstance();
    mDevice = gpsmanager.openUartDevice(UART_DEVICE_NAME);
    Log.i(TAG, "Accessed " + UART_DEVICE_NAME );
} catch (IOException e) {
    Log.w(TAG, "Unable to access UART device", e);
}