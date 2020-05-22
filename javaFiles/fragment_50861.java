class Update {
    public static void main(String[] args) {

        System.out.println("This program will simulate the game of Life.");
        createMatrix();

        // birthAndLive();

        printMatrix();

    }
    public static void createMatrix() {

        Scanner console = new Scanner(System.in);

        System.out.println("Please input the size of your board.");

        System.out.println("Rows:");
        final int rows = console.nextInt();

        System.out.println("Columns:");
        final int columns = console.nextInt();

        System.out.println("Please enter a seed:");
        final long seed = console.nextLong();

        boolean[][] board = new boolean[rows][columns];
        Random seedBool = new Random(seed);

        printMatrix(board);
    }

    public static void printMatrix(boolean[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == false)
                    System.out.print(" - ");
                else
                    System.out.print(" # ");
            }
            System.out.println();
        }

    }
}