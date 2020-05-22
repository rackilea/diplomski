while (fileScanner.hasNext()) {

    allWords.add(fileScanner.next().toLowerCase()); // **** (1)

    count++;

    String distinctWord = (fileScanner.next().toLowerCase());  // **** (2)
    System.out.println (distinctWord.toString());

    if (!allWords.contains(distinctWord)) {

        Vocabulary.add(distinctWord);

    }
}