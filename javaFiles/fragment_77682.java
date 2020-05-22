ArrayList<String> longestWords = new ArrayList<String>();
  int longestWordLength = 0;

  for (int i = 0; i < sentence.length; i++) {
      if (sentence[i].length() > longestWordLength) { // longer
          longestWordLength = sentence[i].length();
          longestWords.clear();
          longestWords.add(sentence[i]);       
      } 
      else if (sentence[i].length() == longestWordLength) { // same length
          longestWords.add(sentence[i]);       
      }
  }

  for (int i = 0; i < longestWords.size(); ++i) 
      System.out.println(longestWords.get(i));