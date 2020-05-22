public static String join(String sep, Iterable<String> it) {
    // Return it[0] + sep + it[1] + sep + .... + it[lastIndex]
    String joined = "";
    boolean first = true;

    for (String s : it) {
        if (first)
            first = false;
        else
            joined += sep;
        joined += s;
    }
    return joined;
}