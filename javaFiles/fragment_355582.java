int d1 = 5;
int d2 = 5;
boolean[][] board = new boolean[d1][d2];
for(int i=0; i<d1; i++) {
  for(int j=0; j<d2; j++) {
    boolean square = Math.random() < .5;
    board[i][j] = square;
    System.out.print("[" + board[i][j] + "]");
  }
  System.out.println();
}