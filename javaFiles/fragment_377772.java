ArrayList<Word> wordList = new ArrayList<Word>();
    String fileName, word;
    int counter;
    Scanner reader = null;
    Scanner scanner = new Scanner(System.in);

    try {
        reader = new Scanner(new FileInputStream(fileName));
    }
    catch(FileNotFoundException e) {
        System.out.println("The file could not be found. The program will now exit.");
        System.exit(0);
    }
    Map<String, Integer> frequencyMap = new HashMap<String, Integer>();
    while (reader.hasNext()) {
       word = reader.next().toLowerCase();
       // This is equivalent to searching every word in the list via hashing (O(1))
       if(!frequencyMap.containsKey(word)) {
          frequencyMap.put(word, 1);
       } else {
          // We have already seen the word, increase frequency.
          frequencyMap.put(word, frequencyMap.get(word) + 1);
       } 
    }

    // Convert our map of word->frequency to a list of Word objects.
    for(Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
      Word word = new Word(entry.getKey());
      word.frequency = entry.getValue();
      wordList.add(word);
    }
}