public static String numericals(String s) {
    int len = s.length();
    Map<Character, Integer> occurrences = new HashMap<>(); // ocurrences
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < len; i++) {
        char ch = s.charAt(i);
        int count = occurrences.getOrDefault(ch, 0) + 1;
        occurrences.put(ch, count);
        sb.append(count);
    }
    return sb.toString();
}