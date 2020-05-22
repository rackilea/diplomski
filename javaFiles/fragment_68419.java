public int nextInt(int radix) {
    // Check cached result
    if ((typeCache != null) && (typeCache instanceof Integer)
    && this.radix == radix) {
        int val = ((Integer)typeCache).intValue();
        useTypeCache();
        return val;
    }
    setRadix(radix);
    clearCaches();
    // Search for next int
    try {
        String s = next(integerPattern());
        if (matcher.group(SIMPLE_GROUP_INDEX) == null)
            s = processIntegerToken(s);
        return Integer.parseInt(s, radix);
    } catch (NumberFormatException nfe) {
        position = matcher.start(); // don't skip bad token
        throw new InputMismatchException(nfe.getMessage());
    }
}