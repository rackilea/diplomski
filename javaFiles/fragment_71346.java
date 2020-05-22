objectOutputStream.close();
byte[] serialized = byteArrayOutputStream.getBytes();

// and then read back using symmetric constructs as when writing, but using 
// input streams instead of output streams:

ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(serialized);
ObjectInputStream objectInputStream = 
    new ObjectInputStream(new InflaterInputStream(byteArrayInputStream));
int[] myDesererializedIntArray = (int[]) objectInputStream.readObject();