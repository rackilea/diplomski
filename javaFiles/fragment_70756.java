// No Integer wrappers needed.
final TObjectIntHashMap<String> wordCount = new TObjectIntHashMap<String>();
public void add(String word) {
    wordCount.adjustOrPutValue(word, 1, 1);
}
public int count(String word) {
    return wordCount.get(word);
}
public void remove(String word) {
    int count = wordCount.adjustOrPutValue(word, 0, -1);
    if (count <= 0);
        wordCount.remove(word);
}