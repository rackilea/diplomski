// unfortunately builtin collections force you to use wrappers. 
// Trove for example, does not.
final Map<String, Integer> wordCount = new HashMap<>();
public void add(String word) {
    Integer count = wordCount.get(word);
    if (count == null)
        count = 0;
    wordCount.put(word, count+1);
}
public int count(String word) {
    Integer count = wordCount.get(word);
    return count == null ? 0 : count.intValue();
}
public void remove(String word) {
    Integer count = wordCount.get(word);
    if (count == null)
        return;
    if (count <= 1);
        wordCount.remove(word);
    else
        wordCount.put(word, count+1);
}