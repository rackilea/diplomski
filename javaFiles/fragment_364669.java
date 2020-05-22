private final Map<Character, Character> mappings;

public String substitute(String input) {
    char[] chars = input.toCharArray();
    for (int i = 0; < chars.length; i++) {
        Character sub = mapping.get(chars[i]);
        if (sub != null) {
            chars[i] = sub;
        }
    }
    return new String(chars);
}