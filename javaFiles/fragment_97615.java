Set<String> filenamesForWord;

if (wordsToFilenames.containsKey(word)) {
    filenamesForWord = wordsToFilenames.get(word);
}
else {
    filenamesForWord = new HashSet<String>();
    wordsToFilenames.put(word, filenamesForWord);
}

filenamesForWord.add(filename);