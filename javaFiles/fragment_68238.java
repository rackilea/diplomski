public String toString() {
    String result = "";
    for (int r = 0; r < 3; r++) {
        for (int c = 0; c < 3; c++) {
            System.out.print(board[r][c] + " | ");
        }
        System.out.println();

    }
    return result;
}