import java.util.Scanner;

public class TicTacToe {

    char board[][] = new char[][]{{'-','-','-'},{'-','-','-'},{'-','-','-'}};

    public static void main(String[] args) {

        TicTacToe ttt = new TicTacToe();
        ttt.run();
    }

    public void run() {
        Scanner input  = new Scanner(System.in);
        int row = -1, col = -1;//just to initialize 
        char symbol = 'o';

        while (true) {
            symbol = (symbol == 'x')?'o':'x';
            boolean error = false;

            System.out.println("Enter a number: ");
            if (input.hasNext()) {
                row = input.nextInt();
                System.out.println("row: " + row);
            } else {
                error = true;
            }
            if (input.hasNext()) {
                col = input.nextInt();
                System.out.println("col: " + col);
            } else {
                error = true;
            }
            if (!error) {
                board[row - 1][col - 1] = symbol;
            }else{
                System.out.println("an error has occurred");
            }
            input.reset();
            this.drawBoard();
        }
    }

    public void drawBoard() {
        System.out.println("The output is: ");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("%c ", board[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}