private boolean inBoard(int row, int col) {
            return (row <= 7)
                    && (row >= 0)
                    && (col <= 7)
                    && (col >= 0);
        }