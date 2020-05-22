public static List<String> getWords(String[] words, char c, int position) {
    List<String> result = new ArrayList<String>;
    for (String s : words) {
        if (position > s.length - 1)
            continue;
        if (s.charAt(position) == c)
            result.add(s);
    }
    return result;
}