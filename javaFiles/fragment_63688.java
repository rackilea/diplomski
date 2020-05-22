public static String replaceRanges(String text, List<Replacement> replacements) {
    StringBuilder s = new StringBuilder(text);

    for (int i = replacements.size() - 1; i>=0; i--) {
        Replacement r = replacements.get(i);
        int begin = r.start;
        int end = r.start + r.before.length();
        if (begin >= 0 && begin < s.length() && end >= 0 && end <= s.length()) {
            if (s.substring(begin, end).equals(r.before)) {
                s.replace(begin, end, r.after);
            }
        }
    }

    return s.toString();
}