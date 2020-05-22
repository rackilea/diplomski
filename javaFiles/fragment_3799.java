public static void main(String[] args) {
    Map<Character, Integer> m = new HashMap<>();
    String testString = "Instructions";
    Map<Character, List<Character>> map = new HashMap<>();

    for (int i = 0; i < testString.length(); i++) {
        char someChar = testString.charAt(i);
        if (someChar == ' ') {
            continue;
        }
        char ch = testString.charAt(i);
        List<Character> characters = map.getOrDefault(Character.toLowerCase(ch), new ArrayList<>());
        characters.add(ch);
        map.put(Character.toLowerCase(ch), characters);
    }
    List<Map.Entry<Character, List<Character>>> list = new ArrayList<>(map.entrySet());

    list.sort((o1, o2) -> {
        if (o1.getValue().size() == o2.getValue().size()) {
            return o1.getKey() - o2.getKey();/// your lexicographic comparing
        }
        return o2.getValue().size() - o1.getValue().size();
    });

    list.forEach(entry -> entry.getValue().forEach(System.out::print));
}