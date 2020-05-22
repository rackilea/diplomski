int i = 0;
 for(char c : myName) {
     i++;
     // Is the char a vowel?
     if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
         // do something - eg print in uppercase
         System.out.print(Character.toUpperCase(c) + " at position " + i);
     } else {
         // do something else - eg print in lowercase
         System.out.print(Character.toLowerCase(c) + " at position " + i);
     }
 }