public int[][] createArrayC(int n, int m) {
     int[][] array = new int[n][];
     for (int i=n-1; i>=0; --i)
         array[i] = new int[m];
     return array;
 }