char[] reverseArr = {'A','B','C','D','E','F','G','Z'};
char[] arr = getReverseArray(reverseArr);

public char[] getReverseArray(char[] arrayToReverse) {
   char[] reverseArray = new char[arrayToReverse.length];
   for(int i = arrayToReverse.length - 1, j = 0; i >= 0; i--, j++) {
       reverseArray[j] = arrayToReverse[i];
   }
   return reverseArray;
}