public static int getCurrentYPosition() {
    for (int i = 0; i < numberOfRows; i++) {
        for (int n = 0; n < board[i].length; n++) {
            if (board[i][n] == '&') {
                return i;
            }
        }
    }
    return -1;
}