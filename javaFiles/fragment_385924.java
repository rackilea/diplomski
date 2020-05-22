public static String replace(String it, Map<String, String> map) {
    StringBuilder sb = new StringBuilder();
    List<String> keys = map.keySet();      // TODO: sort by decreasing length!!
    next: while (it.length() > 0) {
        for (String k : keys) {
            if (it.startsWith(k)) {
                // we have a match!
                sb.append(map.get(k));
                it = it.substring(k.length(), it.length());
                continue next;
            }
        }
        // no match, advance one character
        sb.append(it.charAt(0));
        it = it.substring(1, it.length());
    }
    return sb.toString();
}