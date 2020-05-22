int[] sizeArray(int[] unsignedBytes) {
    int length = unsignedBytes.length;
    int bytesPerColor = 3;
    int remainder = length % bytesPerColor;
    int bytesNeeded = bytesPerColor - remainder;

    int numOfBytes = remainder > 0 ? length + bytesNeeded : length;
    int[] sizedArray = new int[numOfBytes];
    System.arrayCopy(unsignedBytes, 0, sizedArray, length);

    return sizedArray;
}