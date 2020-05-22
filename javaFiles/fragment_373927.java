int rows = 101;
int cols = 101;
int padLen = String.valueOf(rows * cols).length();
String[][] matrix = new String[rows][cols];

for (int x = 1; x < cols; x++) {
  for (int y = 1; y < rows; y++) {
    matrix[x][y] = String.format("%0" + padLen + "d", x*y);
  }
}