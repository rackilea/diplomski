public static Object[] multipleOfSameSet(Object var, int setLength) {
    Object[] out = new Object[setLength];
    for(int i = 0; i < setLength; i++) {
        out[i] = var;
    }
    return out;
}