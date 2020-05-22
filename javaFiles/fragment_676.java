public boolean isSet(byte[] arr, int bit) {
    int index = bit / 8;  // Get the index of the array for the byte with this bit
    int bitPosition = bit % 8;  // Position of this bit in a byte

    return (arr[index] >> bitPosition & 1) == 1;
}