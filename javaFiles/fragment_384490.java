class CheckerBoard {
    public static void main(String[] args) {
        char[][] board = new char[8][8]; // <-- char, not int

        for (int r = 0; r < board.length; r++) { // <-- iterate up to 8, not 7
            for (int c = 0; c < board[r].length; c++) { // <-- use braces
                if ((r + c) % 2 == 0) { // <-- include column in parity check
                    board[r][c] = 'B';
                }
                else {
                    board[r][c] = 'W';
                }

                System.out.print(board[r][c]);   
            }

            System.out.println();
        }
    }
}