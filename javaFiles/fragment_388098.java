public static int keySize = 41;
public static BitSet getBitSet(String key) {
    char[] cs = new StringBuilder(key).reverse().toString().toCharArray();
    BitSet result = new BitSet(keySize);
    int m = Math.min(keySize, cs.length);

    for (int i = 0; i < m; i++)
        if (cs[i] == '1') result.set(i);

    return result;
}
public static String getBitSet(BitSet key) {
    StringBuilder sb = new StringBuilder();
    int m = Math.min(keySize, key.size());

    for (int i = 0; i < m; i++)
        sb.append(key.get(i) ? '1' : '0');

    return sb.reverse().toString();
}