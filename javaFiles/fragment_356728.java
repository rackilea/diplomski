byte[] concatArrays(byte[] ... arrays) {
    int totalLength = 0;
    for (byte[] arr : arrays) {
        totalLength += arr.length;
    }
    byte[] result = new byte[totalLength];
    int start = 0;
    for (byte[] arr : arrays) {
        System.arraycopy(arr, 0, result, start, arr.length);
        start += arr.length;
    }
    return result;
}