Map<Character, Integer> charCount = new HashMap<Character,Integer>();
for (int i = 0; i < s.length(); i++) {
    Integer count = charCount.get(s.charAt(i));
    if (count == null)
        count = 0;
    charCount.put(s.charAt(i), ++count);
}