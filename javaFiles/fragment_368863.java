public static void path(int currentX, int currentY) {
  int[][] ratings = new int[5][5];
  int value = 0;
  for (int i = 0; i<ratings.length; i++) {
    value = Math.abs(i-currentX);
    for (int j = 0; j<ratings[i].length; j++) {
      ratings[i][j] = value + Math.abs(j-currentY);
      System.out.print("-"+ratings[i][j]);
    }
    System.out.println();
  }
}