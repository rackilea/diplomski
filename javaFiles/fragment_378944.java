RandomAccessFile raf = new RandomAccessFile("/path/to/file", "rb");
    long endPositon = raf.length() - Long.SIZE / Byte.SIZE;
    // get last 8 bytes
    raf.seek(endPositon);
    long tagPosition = raf.readLong();
    raf.seek(tagPosition);
    byte[] bytes = new byte[endPositon - tagPosition];
    raf.read(bytes);
    String appendedData = new String(bytes);
    if (appendedData.startsWith(TAG)) {
        // appendedData is what you want
    }