public static void main(String[] args) {
        ChessPosition cp = ChessPosition.valueOf("A1");
        System.out.println(cp);

        cp = ChessPosition.valueOf("H8");
        System.out.println(cp);
    }

    public enum ChessPosition {

        A1(0, 0),
        // ...
        H8(7, 7);


        private final int row;
        private final int column;

        private ChessPosition(int row, int column) {
            this.row = row;
            this.column = column;
        }

        public int getRow() {
            return row;
        }

        public int getColumn() {
            return column;
        }

        public String toString() {
            return name() + " row=" + getRow() + ", column=" + getColumn();
        }
    }