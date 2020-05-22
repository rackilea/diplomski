private boolean isSet(int index) {
    int bitIndex = (index-1) % 8;
    int byteIndex = (index-1) / 8;
    int bitMask = 1 << 7-bitIndex;
    return (b[byteIndex] & bitMask) > 0; 
}