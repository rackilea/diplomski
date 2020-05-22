public static List<String> permutation(final String str) {
    return permutation("", str);
}

private static List<String> permutation(final String prefix, final String str) {
    final List<String> list = new ArrayList<>();

    final int n = str.length();
    if (n == 0) {
        list.add(prefix);
    } else {
        for (int i = 0; i < n; i++) {
            list.addAll(permutation(prefix + str.charAt(i),
                                    str.substring(0, i) + str.substring(i + 1, n)));
        }
    }

    return list;
}