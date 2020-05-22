//Java 8 java.lang.Character source code
static int codePointAtImpl(char[] a, int index, int limit) {
    char c1 = a[index];
    if (isHighSurrogate(c1) && ++index < limit) {
        char c2 = a[index];
        if (isLowSurrogate(c2)) {
            return toCodePoint(c1, c2);
        }
    }
    return c1;
}
//...
static int codePointBeforeImpl(char[] a, int index, int start) {
    char c2 = a[--index];
    if (isLowSurrogate(c2) && index > start) {
        char c1 = a[--index];
        if (isHighSurrogate(c1)) {
            return toCodePoint(c1, c2);
        }
    }
    return c2;
}