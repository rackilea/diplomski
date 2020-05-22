public static void foo()
{
    // ...

    byte[] fifeMBByteAryOne = new byte[5242880];
    ByteArrayStream bStream = new ByteArrayStream(fifeMBByteAryOne);
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(bStream));
    byte[] fifeMBByteAryTwo = new byte[5242880];
    ByteArrayStream bStream2 = new ByteArrayStream(fifeMBByteAryTwo);
    BufferedWriter out2 = new BufferedWriter(new OutputStreamWriter(bStream2));

    // ...

}

private static class ByteArrayStream extends OutputStream {
    int index = 0;
    byte[] container;

    public ByteArrayStream(byte[] container) {
        this.container = container;
    }

    @Override
    public void write(int b) throws IOException {
        container[index++] = (byte)b;
    }

}