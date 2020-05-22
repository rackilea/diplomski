// Current index in the last byte array read
private int index;
private List<byte[]> inputBuffer = new ArrayList<>();
...
@Override
public int read() throws IOException {
   if (inputBuffer.isEmpty()) {
        return -1;
    }
    // Get first element of the List
    byte[] bytes = inputBuffer.get(0);
    // Get the byte corresponding to the index and post increment the current index
    byte result = bytes[index++];
    if (index >= bytes.length) {
        // It was the last index of the byte array so we remove it from the list
        // and reset the current index
        inputBuffer.remove(0);
        index = 0;
    }
    return result;
}