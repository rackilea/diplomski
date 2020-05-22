public class Main {
    public static void main(String[] args) throws IOException {
        String[][] board = {
                { "N", "N", "N", "N", "N" },
                { "N", "N", "N", "N", "N" },
                { "N", "N", "N", "N", "N" },
                { "N", "N", "N", "N", "N" },
                { "N", "N", "N", "N", "N" }
        };

        printArray(board);

        System.out.print("Please enter position X: ");
        Scanner inputx = new Scanner(System.in);
        int readerx = inputx.nextInt();

        System.out.print("Please enter position Y: ");
        Scanner inputy = new Scanner(System.in);
        int readery = inputy.nextInt();

        board[readerx][readery] = "H";

        printArray(board);
    }

    private static void printArray(String[][] board) {
        for (int i = 0; i < board.length; i++) {
            System.out.print(board.length - i + " ");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            if(i == board.length - 1) {
                System.out.println("");
                System.out.print(" ");
                for(int k = 1; k < board[i].length + 1; k++) {
                    System.out.print(" " + k);
                }
            }
            System.out.println("");
        }
    }
}