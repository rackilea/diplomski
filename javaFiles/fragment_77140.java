public void tickDown(int steps) {
    int counter = 1;
    int timer = 0;
    for (int loop = 0; loop < steps; loop++) {
        for (int innerTimer = 0; innerTimer < counter; innerTimer++) {
            board[pacmanBornHeight + innerTimer][pacmanBornWidth] = " ";
        }
        pacmanBornHeight += counter;
        //Allow for wraparounds:
        if (pacmanBornHeight > board.length) {
            pacmanBornHeight = 0;
        }
        board[pacmanBornHeight][pacmanBornWidth] = "V";
        timer++;
    }

    for (int i = 0; i < boardHeight; i++) {
        for (int j = 0; j < boardWidth; j++) {
            System.out.print(board[i][j]);
        }
        System.out.println();
    }
    System.out.println("-------------------------");
}//end tickDown