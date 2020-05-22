public int[][] createArrayA(int n, int m) {
     return new int[n][m];
 }

 public int[][] createArrayB(int n, int m) {
     int[][] array = new int[n][];
     for (int i=0; i<n; ++i)
         array[i] = new int[m];
     return array;
 }