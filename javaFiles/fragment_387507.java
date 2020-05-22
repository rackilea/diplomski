public static void main(String[] args) {
    System.out.println(commonCharacterCount("aabcc","adcaa"));
}

public static int commonCharacterCount(String s1, String s2) {
    Map<Character, Integer> s1CharacterCount = getCharacterCount(s1);
    Map<Character, Integer> s2CharacterCount = getCharacterCount(s2);
    return s1CharacterCount.keySet().stream()
            .filter(s2CharacterCount.keySet()::contains)
            .mapToInt(c -> Math.min(s1CharacterCount.get(c), s2CharacterCount.get(c)))
            .sum();
}

public static Map<Character, Integer> getCharacterCount(String s) {
    Map<Character, Integer> characterCount = new HashMap<>();
    for (char c: s.toCharArray()) {
        characterCount.put(c, characterCount.computeIfAbsent(c, count -> 0) + 1);
    }
    return characterCount;
}