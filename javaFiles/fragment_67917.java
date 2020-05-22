public String[] blankAllEvens( String[] words ) {
   for (int i=0; i <words.length; i++) {
      if (words[i].length() % 2 == 0) {
         words[i] = "";
      }
   }
   return words;
}