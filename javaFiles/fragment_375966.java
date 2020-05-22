public void writeBits3(long value, int amount) {
    if (bitIndex != 0) {
        int remainingBits = 8 - bitIndex;
        int bytePos = out.position() - 1;
        byte current = out.get(bytePos);
        int shiftAmount = amount - remainingBits;

        int bitsWritten = 0;
        if (shiftAmount < 0) {
            bitsWritten = amount;
            out.put(bytePos, (byte) (current | (value << -shiftAmount)));
        } else {
            bitsWritten = remainingBits;
            out.put(bytePos, (byte) (current | (value >> shiftAmount)));
        }

        bitIndex += bitsWritten;
        amount -= bitsWritten;
        if (bitIndex >= 8) {
            bitIndex = 0;
        }
    }
    if (amount <= 0) {
        return;
    }
    bitIndex = amount & 7;
    int newAmount = amount - bitIndex;
    long newValue = (value >> bitIndex);
    for (; newAmount >= 8; newAmount -= 8) {
        out.put((byte) (newValue >> newAmount));
    }
    out.put((byte) (value << (8 - bitIndex)));
}