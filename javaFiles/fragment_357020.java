private static void maxify(int[][][] tableau) {
  int ii = tableau.length;
  int jj = tableau[0].length;
  int kk = tableau[0][0].length;
  // Sort on k-rows
  for (int i = 0; i < ii; i++) {
    for (int j = 0; j < jj; j++) {
      // Since k-rows are already standard arrays, no temporary array needed here.
      reverseSort(tableau[i][j]);
    }
  }
  // Sort on j-rows
  for (int i = 0; i < ii; i++) {
    for (int k = 0; k < kk; k++) {
      int[] temp = new int[jj];
      for (int j = 0; j < jj; j++) {
        temp[j] = tableau[i][j][k];
      }
      reverseSort(temp);
      for (int j = 0; j < jj; j++) {
        tableau[i][j][k] = temp[j];
      }
    }
  }
  // Sort on i-rows
  for (int j = 0; j < jj; j++) {
    for (int k = 0; k < kk; k++) {
      int[] temp = new int[ii];
      for (int i = 0; i < ii; i++) {
        temp[i] = tableau[i][j][k];
      }
      reverseSort(temp);
      for (int i = 0; i < ii; i++) {
        tableau[i][j][k] = temp[i];
      }
    }
  }
}

private static void reverseSort(int[] a) {
  Arrays.sort(a);
  for (int i = 0; i < a.length / 2; i++) {
    a[i] ^= a[a.length - i - 1];
    a[a.length - i - 1] ^= a[i];
    a[i] ^= a[a.length - i - 1];
  }
}