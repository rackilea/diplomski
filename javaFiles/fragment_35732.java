public static char[] initializeDisplay(char[] wordToGuess) {
       /* No need to store the length
       int len=wordToGuess.length;
       System.out.print(len);
       char[] charArray ={ '-' }; */

       // Pre-define the length at initialization 
       char[] charArray = new char[wordToGuess.length];

       // Fills the array with the char '-' 
       Arrays.fill(charArray, '-');

       return charArray;

   }