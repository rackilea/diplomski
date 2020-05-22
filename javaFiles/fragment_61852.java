private static final String[] symbols = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h",
        "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "!", "@", "#", "$", "%", "^", "&",
        "*", "~", "?" };
public static String getSequence(final int i) {
    return symbols[i / (symbols.length * symbols.length)] + symbols[(i / symbols.length) % symbols.length]
            + symbols[i % symbols.length];
}