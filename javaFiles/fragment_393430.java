for (int i = 0; i < rows; i++) {
   for (int j = 0; j < col; j++) {
      bw.write(arr[i][j] + ((j == col-1) ? "" : ","));
   }
   bw.newLine();
}