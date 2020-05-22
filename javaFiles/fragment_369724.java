public static char[][] readBoard(InputStream in) throws IOException {
    char[][] board = new char[3][3];
    for(int i=0;i<9;i++) {
        board[i/3][i%3] = (char) in.read();
    }
    return board;
}

public static void writeBoard(OutputStream out, char[][] board) throws IOException {
    for(int i=0;i<9;i++) {
        out.write(board[i/3][i%3]);
    }
}