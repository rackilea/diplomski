public static void main(String[] args) {

            Board board = new Board();
            String[] newGrid = new String[] { "0", "1", "2", "3", "X", "5", "6", "7", "8" };
            board.setGrid(newGrid);

            // Instead of using clone methods, create new instance from source object
            Board clone = new Board(board);

            System.out.println(clone.getGrid() == board.getGrid()); // false => deep copy done
    }