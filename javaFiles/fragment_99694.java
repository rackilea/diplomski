for (String word : words) {
     numVowels = 0;
     for (int i = 0; i < word.length(); i++) {
          ch = word.charAt(i);
          if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
              numVowels++;
          }
     }
     if (numVowels == 1) {
         oneVowel.add(word);
     } else if (numVowels == 2) {
         twoVowel.add(word);
     } else if (numVowels == 3) {
         threeVowel.add(word); 
     }
}