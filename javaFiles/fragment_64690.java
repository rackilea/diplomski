public List<byte[]> splitArray(byte[] array, int blockSize) {
    if (array.length < blockSize) {
        // shortcut if array is too small, will pad end with 0s
        return Arrays.asList(Arrays.copyOf(array, blockSize));
    } else if (array.length == blockSize) {
        // shortcut if array length is already blockSize
        return Arrays.asList(array);
    }
    List<byte[]> list = new ArrayList<>();
    int from = 0;
    int to;
    while ((to = from + blockSize) <= array.length) {
        // keep adding to list while array has another blockSize range of elements
        list.add(Arrays.copyOfRange(array, from, to));
        from = to;
    }
    if (from != array.length) {
        // array did not divide into blockSize evenly, fill last block
        // with remaining elements. Pads end with 0s
        byte[] leftOver = new byte[blockSize];
        System.arraycopy(array, from, leftOver, 0, array.length - from);
        list.add(leftOver);
    }
    return list;
}