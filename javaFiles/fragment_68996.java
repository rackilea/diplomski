public String getPattern (Set<Character> guesses, String word) {
    for (int i=0; i<word.length(); ++i) {
         char c = word.charAt(i);
         if (!guesses.contains(c)) 
             word = word.replace(c, '-');
    }
    return word;
}