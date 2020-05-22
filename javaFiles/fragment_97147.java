private byte[] pad(byte[] data, int size) {
    byte padLength = (byte)(size - (data.length % size));
    byte[] paddedData = new byte[data.length + padLength];
    System.arraycopy(data, 0, paddedData, 0, data.length);
    for (int i = data.length; i < paddedData.length; i++)
        paddedData[i] = (byte)padLength;
    return paddedData;
}