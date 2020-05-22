static boolean isSurrogate(char c) {
    return Character.isHighSurrogate(c) || Character.isLowSurrogate(c);
}

static boolean isNotSurrogate(char c) {
    return !isSurrogate(c);
}

...

if (isNotSurrogate(c)) {
    sb.append(firstChar);
}