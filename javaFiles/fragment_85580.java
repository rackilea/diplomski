public static String translate(final String str, List<String> from, List<String> to, int index) {
    StringBuilder components = new StringBuilder();
    String token, replace;
    int p;

    if (index < from.size()) {
        token = from.get(index);
        replace = to.get(index);
        p = 0;

        for (int i = str.indexOf(token, p); i != -1; i = str.indexOf(token, p)) {
            if (i != p) {
                components.append(translate(str.substring(p, i), from, to, index + 1));
            }
            components.append(replace);
            p = i + token.length();
        }
        return components.append(translate(str.substring(p), from, to, index + 1)).toString();
    }

    return str;
}

public static String translate(final String str, List<String> from, List<String> to) {
    if (null == str) {
        return null;
    }
    return translate(str, from, to, 0);
}