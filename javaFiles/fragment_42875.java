public static void main() {
    int[] prevRow = { 1 };
    printRow(prevRow);

    for (int row = 0; row < 10; ++row) {
      int[] nextRow = calcNextRow(prevRow);
      printRow(nextRow);
      prevRow = nextRow;
    }
  }