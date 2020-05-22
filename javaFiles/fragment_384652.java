public TestConstructor(String params) {
    // whatever
}

public TestConstructor(String... paramParts) {
    this(combineParts(paramParts));
}

private static String combineParts(String[] parts) {
    StringBuilder sb = new StringBuilder();
    for (String part : parts) {
        sb.append(part);
    }
    return sb.toString();
}