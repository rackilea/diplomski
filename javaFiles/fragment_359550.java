int appendDummyOnes(final int value, final int size) {
    return (value << size) | (-1 >>> (Integer.SIZE - size));
}

int remarkDummyOnes(final int value, final int size) {
    return value | (-1 >>> (Integer.SIZE - size));
}