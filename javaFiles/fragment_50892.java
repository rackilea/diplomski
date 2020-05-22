for(int i=0;i<word.length();i++)
 {
     if(letter==word.charAt(i))
     {
         char[] wordCharsArray = hiddenWord.toCharArray();
         wordCharsArray[i] = letter;
         hiddenWord= String.valueOf(wordCharsArray);
     }
 }