int x = 10 + R_num.nextInt(10);

    for (int y = 0; y < x; y++) {
        for (int a = 0; a < 3; a++) {
            // System.out.println("a="+a);

            if (a == 0) {
                firstrow = R_num.nextInt(3);
                secondrow = R_num.nextInt(3);
            }

            else if (a == 1) {
                firstrow = 3 + R_num.nextInt(3);
                secondrow = 3 + R_num.nextInt(3);
            }

            else if (a == 2) {
                firstrow = 6 + R_num.nextInt(3);
                secondrow = 6 + R_num.nextInt(3);
            }

           /* System.out.println("firstrow"+"="+firstrow);
            System.out.println("secondrow"+"="+secondrow);*/

            for (int i = 0; i < 9; i++) {
                carry[i] = blockS[firstrow][i];
                blockS[firstrow][i] = blockS[secondrow][i];
                blockS[secondrow][i] = carry[i];
            }
        }
        // switching the rows complete

        // Switchicng the column
        for (int a = 0; a < 3; a++) {
           /* System.out.println("a="+a);*/

            if (a == 0) {
                firstcol = R_num.nextInt(3);
                secondcol = R_num.nextInt(3);
            }

            else if (a == 1) {
                firstcol = 3 + R_num.nextInt(3);
                secondcol = 3 + R_num.nextInt(3);
            }

            else if (a == 2) {
                firstcol = 6 + R_num.nextInt(3);
                secondcol = 6 + R_num.nextInt(3);
            }

           /* System.out.println("firstcol"+"="+firstcol);
            System.out.println("secondcol"+"="+secondcol);*/

            for (int i = 0; i < 9; i++) {
                carry[i] = blockS[i][firstcol];
                blockS[i][firstcol] = blockS[i][secondcol];
                blockS[i][secondcol] = carry[i];
            }
        }
    }
    // Switchicng the column complet

    // Switchicng the grids
    firstgrid = 1 + Grid_R_num.nextInt(3);
    secondgrid = 1 + Grid_R_num.nextInt(3);

   /* System.out.println("firstgrid"+"="+firstgrid);
    System.out.println("secondgrid"+"="+secondgrid);*/

    if ((firstgrid == 1 && secondgrid == 2) || (firstgrid == 2 && secondgrid == 1)) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 9; j++) {
                carry[j] = blockS[i][j];
                blockS[i][j] = blockS[i + 3][j];
                blockS[i + 3][j] = carry[j];
            }
    } else if ((firstgrid == 2 && secondgrid == 3) || (firstgrid == 3 && secondgrid == 2)) {
        for (int i = 3; i < 6; i++)
            for (int j = 0; j < 9; j++) {
                carry[j] = blockS[i][j];
                blockS[i][j] = blockS[i + 3][j];
                blockS[i + 3][j] = carry[j];
            }
    } else if ((firstgrid == 1 && secondgrid == 3) || (firstgrid == 3 && secondgrid == 1)) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 9; j++) {
                carry[j] = blockS[i][j];
                blockS[i][j] = blockS[i + 6][j];
                blockS[i + 6][j] = carry[j];
            }
    }
    // Swithing complete of tow grids

    // suffling the puzzle
    int firstnum, secondnum, shuffle;

    shuffle = 3 + R_num.nextInt(6);

    for (int k = 0; k < shuffle; k++) {
        firstnum = 1 + R_exnum.nextInt(9);
        secondnum = 1 + R_exnum.nextInt(9);


        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++) {
                if (blockS[i][j] == firstnum) {
                    blockS[i][j] = secondnum;
                    continue;
                }

                if (blockS[i][j] == secondnum)
                    blockS[i][j] = firstnum;
            }
    }
    return blockS;
}

// will save the complet puzzle