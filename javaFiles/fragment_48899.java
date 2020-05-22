static String[] randomWord()
  {
    String[] randomWords = {"dog", "cat", "monkey"}
    String random = randomWords[(int)(Math.random() * randomWords.length)];
    return random; 
  }