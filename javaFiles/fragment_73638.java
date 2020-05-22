class PackedBitsOutputStream {

    private OutputStream outputStream;
    private int numBufferedBits;
    private byte bufferedBits;

    PackedBitsOutputStream(OutputStream os) {
        outputStream = os;
    }

    void writeBitSet(int data, int relevantBits) {
        bufferedBits = (byte) (bufferedBits | (data << bufferedBits));
        numBufferedBits += relevantBits;
        if (numBufferedBits >= 8) {
            outputStream.write(bufferedBits);
            numBufferedBits -= 8;
            bufferedBits = (byte) (data >> (relevantBits - numBufferedBits));
        }
    }

    void flush() {
        outputStream.write(bufferedBits);
        bufferedBits = 0;
        numBufferedBits = 0;
        outputStream.flush();
    }

    void close() {
        flush();
        outputStream.close();
    }
}