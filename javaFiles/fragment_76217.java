public static void sortStrings(Collator collator, 
                           String[] words) {
  String tmp;
     for (int i = 0; i < words.length; i++) {
        for (int j = i + 1; j < words.length; j++) { 
           if (collator.compare(words[i], words[j]) > 0) {
              tmp = words[i];
              words[i] = words[j];
              words[j] = tmp;
           }
         }
      }
 }