HashMap<String, Integer> mapOfWords = new HashMap<String, Integer>();

   while (file.hasNextLine()) {
        String s = file.nextLine(); 
        String[] words = s.split("\\s");
        int count;

        if (isStringWanted(s) == false) {
           continue;  
        } 

        for (String word : words) {
           if (mapOfWords.get(word) == null) {
              mapOfWords.put(word, 1);
           }
           else {
              count = mapOfWord.get(word);
              mapOfWords.put(word, count + 1);
           }
        }
      }

private boolean isStringWanted(String s) {
    String[] checkStrings = new String[] {"chelsea", "Liverpool", "#LFC"};

    for (String check : checkString) {
        if (s.contains(check)) {
           return false;
        }
    }
    return true;
}