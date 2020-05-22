// keys stored in reverse order of the original string.
NavigableMap<String, Boolean> wordmap
String search = "dcba";
// retains hte order keys were added.
Map<String, Boolean> results = new LinkedHashMap<String, Boolean>();
for(int i=search.size();i>=1;i--) {
    String s = search.substring(0, i);
    results.putAll(wordmap.subMap(s, s+'\uFFFF')); // ignores duplicates
}