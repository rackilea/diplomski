while (fileScanner.hasNext()) {
    String word = fileScanner.next().toLowerCase();
    allWords.add(word); // **** (1)
    count++;
    // String distinctWord = (fileScanner.next().toLowerCase());  // **** (2)
    System.out.println (word);
    vocabularySet.add(word); // a HashSet
}