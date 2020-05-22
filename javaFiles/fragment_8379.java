int[] grid = {5, 3, 1, 2, 0, 4, 1, 1, 3 };
int [][] matrix = new int[3][3];

for (int x = 0; x < 3; x++) {
  for (int y = 0; y < 3; y++) {
    matrix[x][y] = grid[x + y * 3];
  }   
}