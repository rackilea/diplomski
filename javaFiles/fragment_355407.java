public static double[] extractAccelerometer(BluetoothGattCharacteristic c) {

    Integer x = c.getIntValue(FORMAT_SINT8, 0);
    Integer y = c.getIntValue(FORMAT_SINT8, 1);
    Integer z = c.getIntValue(FORMAT_SINT8, 2) * -1;

    double scaledX = x / 64.0;
    double scaledY = y / 64.0;
    double scaledZ = z / 64.0;

    return new double[] {scaledX, scaledY, scaledZ};
}