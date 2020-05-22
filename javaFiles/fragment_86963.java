@Override
public int read(byte b[], int off, int len) throws IOException {
    // Check parameters
    if (b == null) {
        throw new NullPointerException();
    } else if (off < 0 || len < 0 || len > b.length - off) {
        throw new IndexOutOfBoundsException();
    } else if (len == 0) {
        return 0;
    }
    if (inputBuffer.isEmpty()) {
        return -1;
    }
    int read = 0;
    // Iterate as long as don't get the expected bytes amount and the list is not empty
    do {
        byte[] bytes = inputBuffer.get(0);
        int lg = Math.min(bytes.length - index, len);
        // Copy the bytes from "bytes" to "b"
        System.arraycopy(bytes, index, b, off, lg);
        // Update all counters
        read += lg;
        off += lg;
        index += lg;
        len -= lg;
        if (index >= bytes.length) {
            // It was the last index of the byte array so we remove it from the list
            // and reset the current index
            inputBuffer.remove(0);
            index = 0;
        }
    } while (read < len && !inputBuffer.isEmpty());

    return read;
}