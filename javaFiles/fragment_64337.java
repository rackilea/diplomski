int rowCount = 5;
int colCount = rowCount;
int[][] result = new int[rowCount][colCount];
int[] input = { 51, 88, 93, 89, 91, 26, 51, 47, 47, 31, 67, 68, 46, 92, 39};
int k = 0;
for (int row = 0; row < rowCount; row++) {
  for (int column = 0; column < colCount; column++) {
    result[row][column] = row > column ? 0 : input[k++];
  }
}