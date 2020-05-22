public int inputBoardSize() {
    while (flag) {
        System.out.print("Enter the number of grids you want to play with:");
        validateBoardSize(scan.next());
    }
    printBoard(boardSize);
    return boardSize;
}

protected void validateBoardSize(String input) {

    try {
        boardSize = Integer.parseInt(input);
        if (boardSize < 3 || boardSize > 10) {
            System.out.println("Please choose a board size between 3 and 10");
        }
        else {
            flag = false;
        }
    } 
    catch (NumberFormatException e) {
        e.getMessage();
        System.out.println("Please enter a number");
    }
}