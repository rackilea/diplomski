// HeapByteBuffer

public int getInt() {
    return Bits.getInt(this, ix(nextGetIndex(4)), bigEndian);
}

public int getInt(int i) {
    return Bits.getInt(this, ix(checkIndex(i, 4)), bigEndian);
}