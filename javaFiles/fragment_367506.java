int[][] blockS = { { 4, 3, 5, 8, 7, 6, 1, 2, 9 },
                  { 8, 7, 6, 2, 1, 9, 3, 4, 5 },
                  { 2, 1, 9, 4, 3, 5, 7, 8, 6 },
                  { 5, 2, 3, 6, 4, 7, 8, 9, 1 },
                  { 9, 8, 1, 5, 2, 3, 4, 6, 7 },
                  { 6, 4, 7, 9, 8, 1, 2, 5, 3 },
                  { 7, 5, 4, 1, 6, 8, 9, 3, 2 },
                  { 3, 9, 2, 7, 5, 4, 6, 1, 8 },
                  { 1, 6, 8, 3, 9, 2, 5, 7, 4 } };

 Random R_num = new Random(); // random numbers to exchange rows
 Random Grid_R_num = new Random();// random numbers to exchange GRIDS
 Random R_exnum = new Random();
 Random H_Rnum = new Random();
 int carry[] = new int[9];
 int[][] blockh = new int[9][9];
 int[][] blockc = new int[9][9];

  int firstrow,secondrow,firstcol,secondcol,firstgrid,secondgrid;

 int gc = 0;