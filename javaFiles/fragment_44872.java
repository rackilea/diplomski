private boolean inBoard(int row, int col) {
        return (row <= 8)
                && (row >= 1)
                && (col <= 8)
                && (col >= 1);
    }