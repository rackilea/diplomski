private boolean isSet(int index) {
    int bitIndex = index % 8;
    int byteIndex = index / 8;
    int bitMask = 1 << bitIndex;
    return (b[byteIndex] & bitMask) > 0; 
}