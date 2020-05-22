int[][] myArray = new int[6][6];
  for(int ii = 0; ii < 6; ii++ )
  {
      for(int kk = 0; kk < 6; kk++ )
      {
      //math expression
          myArray[ii][kk] = (ii + kk)%6+1;
      }
  }