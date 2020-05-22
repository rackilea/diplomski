private static int[][] resizeArray (int[][] oldArray, int newSize) {
   int oldSize = oldArray[0].length; //number of columns
   int preserveLength = Math.min(oldSize, newSize);
   int[][] newArray = new int[oldArray.length][newSize];
   for(int i = 0; i < oldArray.length; i++) {
       for(int j = 0; j < preserveLength; j++) {
           newArray[i][j] = oldArray[i][j];
       }
   } 
   return newArray;  
}