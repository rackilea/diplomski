public static int[] calcNextRow(int[] prevRow) {
    int[] newRow = new int[prevRow.length + 1];
    newRow[0] = 1; 
    for (int i = 1; i < prevRow.length; ++i) {
      newRow[i] = (prevRow[i-1] + prevRow[i]) % 2; 
    }
    newRow[prevRow.length] = 1;
    return newRow;
  }