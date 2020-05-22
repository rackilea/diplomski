for (int i = 0; i < 5; i++) {
    for (int j = 0; j < 5; j++) {
        if ((board[j][i].equals(p) && board[j + 1][i + 1].equals(p)
                && board[j + 2][i + 2].equals(p) && board[j + 3][i + 3]
                .equals(p))) {
            this.win1();
            return false;
        }
    }
}

for (int i = 3; i < 8; i++) {
    for (int j = 0; j < 5; j++) {
        if ((board[j][i].equals(p) && board[j + 1][i - 1].equals(p)
                && board[j + 2][i - 2].equals(p) && board[j + 3][i - 3]
                .equals(p))) {
            this.win1();
            return false;
        }
    }
}