private byte[] readData(File f, int startByte, int chunkSize) throws Exception {
    RandomAccessFile raf = new RandomAccessFile(f, "r");
    raf.seek(startByte);
    byte[] data = new byte[chunkSize];
    int bytesRead = raf.read(data);
    if (bytesRead != chunkSize) {
         byte[] smallerData = new byte[bytesRead];
         System.arraycopy(data, 0, smallerData, 0, bytesRead);
         data = smallerData;
    }
    raf.close();
    return data;
}