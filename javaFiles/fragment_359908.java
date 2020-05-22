public static void main(String[] args) {


    int[][] magic = new int[7][5]; //<<Create a new Bidimentional Array
    odd(magic);
}

public static void odd(int[][] magic) {
      int N = magic.length; //it will take the length in position 0 from array well the 7 [7][5] so if i use [2][10] it will 2 the length DON'T TRY USE [0][n] or u'll get an error
      int row = N - 1; // 7 - 1 = 6 (or your value used [VALUE_TAKEN][n])
      int col = N / 2; // 7 / 2 = 3 (or your value used [VALUE_TAKEN][n])
      magic[row][col] = 1; //Here you get an error if you used [0][n], BUT if you used [7][5] well it will say magic[6][3] = 1
      for (int i = 2; i <= N * N; i++) { //for i=2 ; i < 14; i ++
        if (magic[(row + 1) % N][(col + 1) % N] == 0) { // (col + 1) % N] =  0,(col + 1) % N] = 4, so if magic[0,4] == 0 enter
          row = (row + 1) % N;  //SO IF IT'S TRUE YOU ENTER
          col = (col + 1) % N;
        } else {
          row = (row - 1 + N) % N; //it was not true
        }
        magic[row][col] = i; //no matter what you will be here
      }
    }