String[][] result = new String[ROW_SIZE][COLUMN_SIZE];
for(int a = 0; a < ROW_SIZE; a++){
   for(int b = 0; b < COLUMN_SIZE; b++){
      StringBuilder builder = new StringBuilder(8);        
      builder.append(arrayInput1[a][b]);
      builder.append(arrayInput1[a][b]); 
      builder.append(arrayInput1[a][b]);
      builder.append(arrayInput2[a][b]);
      builder.append(arrayInput3[a][b]);
      builder.append(arrayInput4[a][b]);
      builder.append(arrayInput5[a][b]);
      builder.append(arrayInput6[a][b]);
      builder.append(arrayInput7[a][b]);
      builder.append(arrayInput8[a][b]);
      result[a][b] = builder.toString();
   }
}