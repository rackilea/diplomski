static Map<Character, Integer> countFrequency(String str) {
    Map<Character, Integer> map = new LinkedHashMap<>();
    for (char ch : str.toCharArray()) {
        if (map.containsKey(ch)) {
            map.put(ch, 1 + map.get(ch));
        } else {
            map.put(ch, 1);
        }
    }
    return map;
}