public static int[][] trim(int[][] mtx, int rmin, int rmax, int cmin, int cmax) {
   int[][] result = new int[rmax-rmin+1][];
   for (int r = rmin, i = 0; r <= rmax; r++, i++) {
      result[i] = Arrays.copyOfRange(mtx[r], cmin, cmax+1);
   }
   return result;
}

public static int[][] trim(int[][] mtx, int trimmed) {
   int cmin = mtx[0].length;
   int rmin = mtx.length;
   int cmax = -1;
   int rmax = -1;

   for (int r = 0; r < mtx.length; r++)
      for (int c = 0; c < mtx[0].length; c++)
         if (mtx[r][c] != trimmed) {
            if (cmin > c) cmin = c;
            if (cmax < c) cmax = c;
            if (rmin > r) rmin = r;
            if (rmax < r) rmax = r;
         }

   return trim(mtx, rmin, rmax, cmin, cmax);
}

public static void main (String[] args) {
   int[][] array = new int[][]{
      {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
      {0, 0, 0, 1, 1, 1, 0, 0, 0, 0},
      {0, 0, 0, 1, 1, 1, 1, 0, 0, 0},
      {0, 0, 1, 1, 0, 1, 1, 0, 0, 0},
      {0, 0, 1, 1, 0, 1, 0, 0, 0, 0},
      {0, 0, 0, 1, 1, 1, 1, 0, 0, 0},
      {0, 0, 0, 1, 1, 1, 1, 0, 0, 0},
      {0, 0, 0, 0, 0, 1, 0, 0, 0, 0}
   };
   int[][] trim = trim(array, 0);
   System.out.println(Arrays.deepToString(trim));
}