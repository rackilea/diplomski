Random random = new Random();
boolean[][] arr = new boolean[25][25];
for(int i = 0; i < 25; i++) {
   for(int j = 0; j < 25; j++) {
      arr[i][j] = random.nextBoolean();
   }
}