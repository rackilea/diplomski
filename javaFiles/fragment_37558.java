Set<Character> guesses = new HashSet<Character>();

 // add a guess
 guesses.add('e');
 guesses.add('r');
 guesses.add('a');
 guesses.add('e'); // will not be added, already in the set

 // test
 if (guesses.contains('e')) { ... }

 // test if a word is "guessed"
 boolean foundIt = true;
 for (char c:word.toCharArray()) {
    if (!guesses.contains(c)) {
      foundIt = false;
      break;
    }
 }
 // foundIt is true if all chars of word have been guessed

 // print
 for (char c:guesses)
   System.out.print(c);  // prints: aer