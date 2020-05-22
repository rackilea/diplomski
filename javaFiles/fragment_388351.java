ArrayList<String> strings = new ArrayList<>(Arrays.asList("hello world", "this is a test"));
HashMap<String, String> map = new HashMap<>();

map.put("hello", "wordForHello");
map.put("world", "wordForWorld");
map.put("this", "wordForThis");
map.put("is", "wordForIs");
map.put("a", "wordForA");
map.put("test", "wordForTest");

ArrayList<String> sentence = new ArrayList<>();

for (String str : strings) {
    String[] words = str.split(" ");
    for (String word : words) {
        if (map.containsKey(word)) {
            sentence.add(map.get(word));
        }
    }
    System.out.println(sentence);
    sentence = new ArrayList<>();
}