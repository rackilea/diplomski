private Socket socket;

public void sendBytes(byte[] myByteArray) throws IOException {
    sendBytes(myByteArray, 0, myByteArray.length);
}

public void sendBytes(byte[] myByteArray, int start, int len) throws IOException {
    if (len < 0)
        throw new IllegalArgumentException("Negative length not allowed");
    if (start < 0 || start >= myByteArray.length)
        throw new IndexOutOfBoundsException("Out of bounds: " + start);
    // Other checks if needed.

    // May be better to save the streams in the support class;
    // just like the socket variable.
    OutputStream out = socket.getOutputStream(); 
    DataOutputStream dos = new DataOutputStream(out);

    dos.writeInt(len);
    if (len > 0) {
        dos.write(myByteArray, start, len);
    }
}