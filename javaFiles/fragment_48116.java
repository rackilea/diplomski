public static boolean isDouble(String word) {
   boolean isDouble = false;
   try {
     Double.parseDouble(word);
     isDouble = true;
   } catch (NumberFormatException nfe) {
     // empty on purpose, as most of the time, input will not be a number!
   }
   return isDouble;
}