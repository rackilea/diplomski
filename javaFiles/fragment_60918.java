// DirectByteBuffer

private int getInt(long a) {
    if (unaligned) {
        int x = unsafe.getInt(a);
        return (nativeByteOrder ? x : Bits.swap(x));
    }
    return Bits.getInt(a, bigEndian);
}

public int getInt() {
    return getInt(ix(nextGetIndex((1 << 2))));
}

public int getInt(int i) {
    return getInt(ix(checkIndex(i, (1 << 2))));
}