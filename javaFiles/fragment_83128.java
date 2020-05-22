for (count = 0; count < 1001; count++) {
    int movecount = 0; 
    int row, col;
    int player = 1;
    do {
        //pick a row
        row = r.nextInt(3);
        //pick a col
        col = r.nextInt(3);
        //check if spot is empty
        if (list[row][col]>0) {continue;}
        //if empty, move current player there, add to count
        list[row][col] = player;
        if (CheckRowWin(player, list)) {
            System.out.println("Player " + player + " won");
            break;
        } else {
            System.out.println("Tie Game");
        }
        movecount++;
        //switch player turn
        player = 3 - player;

    } while (movecount < 9);
    // don't forget to reset movecount
    // so that the inner loop will run again
    movecount = 0;
    // clear the "board" for the next game
    // note: using two nested loops is slow and inefficient
    // but it goes along with the theme of learning loops
    for (int r = 0; r < 3; r++) {
        for (int c = 0; c < 3; c++) {
            list[r][c] = 0;
        }
    }
}