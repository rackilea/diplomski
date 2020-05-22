for (int i = 0; i < numberOfRows; i++) {
    for (char ch : board[i]) {
        if (ch == '&') {
            return i;
        }
    }
}
return -1;