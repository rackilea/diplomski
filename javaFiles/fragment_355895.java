public static List<String> substrings(final String source) {
    final List<String> list = new ArrayList<>();
    for (int i = 0; i < source.length(); i++) {
        for (int j = i + 1; j <= source.length(); j++) {
            list.add(source.substring(i, j));
        }
    }
    return list;
}