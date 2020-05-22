static int[] utf8ByteIndexes(String s) {
    int[] byteIndexes = new int[s.length()];
    int sum = 0;
    for (int i = 0; i < s.length(); i++) {
        byteIndexes[i] = sum;
        int c = s.codePointAt(i);
        if (Character.charCount(c) == 2) {
            i++;
            byteIndexes[i] = sum;
        }
        if (c <=     0x7F) sum += 1; else
        if (c <=    0x7FF) sum += 2; else
        if (c <=   0xFFFF) sum += 3; else
        if (c <= 0x1FFFFF) sum += 4; else
        throw new Error();
    }
    return byteIndexes;
}