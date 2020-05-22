public class PacmanKata {
    static String[] board;
    static int pacmanPosition;
    static int boardHeight;
    static int boardWidth;

    public static void main(String[] args) {

        PacmanKata kata = new PacmanKata(10,10);
        kata.tickUp(7);
        kata.tickRight(9);
    }

    public PacmanKata(int height, int width) {
        boardHeight = height;
        boardWidth = width;
        board = new String[height*width];
        int offset = (width + 1) % 2;
        pacmanPosition = (int) Math.floor((height + offset)*width/2);

        for (int i = 0; i < board.length; i++) {
            board[i] = "*";
        }
        board[pacmanPosition] = "V";
    }

    private void printBoard() {
        for (int i = 0; i < board.length; i++) {
            System.out.print(board[i]);
            if ((i+1) % boardWidth == 0) {
                System.out.println();
            }
        }
        System.out.println("-------------------------");
    }

    public void tickUp(int steps) {
        int counter = -1 * boardHeight;
        for (int loop = 0; loop < steps; loop++) {
            //Current position = ' '
            board[pacmanPosition] = " ";
            //Pacman's position changes:
            pacmanPosition += counter;
            //Allow for wraparounds:
            if (pacmanPosition < 0) {
                pacmanPosition += board.length;
            }
            //Update the board with Pacman's new position:
            board[pacmanPosition] = "V";
        }

        printBoard();
    }//end tickUp

    public void tickRight(int steps) {
        int counter = 1;
        for (int loop = 0; loop < steps; loop++) {
            //Current position = ' '
            board[pacmanPosition] = " ";
            //Pacman's position changes:
            pacmanPosition += counter;
            if (pacmanPosition % boardWidth == 0) {
                pacmanPosition -= boardWidth;
            }
            //Update the board with Pacman's new position:
            board[pacmanPosition] = "V";
        }

        printBoard();
    }//end tickUp
}