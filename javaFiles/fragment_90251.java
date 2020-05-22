for (int i = 0; i < row; i++) {
     for (int j = 0; j < column; j++) {
          if ((i == j) || (i+j+1) == row )
              System.out.print(my2dArray1[i][j]);//print content if diagonal
          else 
              System.out.print('\t');//else print only tab space
     }
     System.out.println();
}