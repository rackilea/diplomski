private byte[][] filterByteArrayValues(final byte[][] values) {
    final Map<String,byte[]> res = new HashMap<>();
    for (final byte[] value : values) {
        res.put(generateCheckSum(value), value);
    }
    return res.values().toArray(new byte[res.size()][]);
}