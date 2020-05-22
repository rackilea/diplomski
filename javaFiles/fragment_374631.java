Map<Character, Integer> map = new HashMap<>();
for (int i = 0; i + 'A' <= 'Z'; i++) {
    char key = (char) ('A' + i);
    int defaultValue = i + 1;
    map.put(key, defaultValue);
}