private static Map<Character, Integer> countChars(char[] arr) {
    Map<Character, Integer> counts = new HashMap<>();
    for (char c : arr) {
        Integer count = counts.get(c);
        if (count == null) {
            count = 1;
        } else {
            count += 1;
        }
        counts.put(c, count);
    }
    return counts;
}