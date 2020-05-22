System.out.print("  ");
    int[] column = {1,2,3,4,5,6,7,8,9};
    for (int counter = 0; counter<column.length;counter++){
        System.out.print(counter); // print column number
    }
    System.out.println("");
    System.out.println(""); // empty row

    //9x9 grid output
    String[][] board = new String [9][9];
    for (int r = 0; r<board.length;r++){
        System.out.print(r+" "); // print row number
        for (int c = 0; c <board.length;c++){

            board [r][c] ="?";

            System.out.print(board[r][c]); // print cell value
            }

            System.out.println("");
    }