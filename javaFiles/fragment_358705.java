import java.util.Scanner;
class TicTacToe

{
public static void main(String[] args)

{
    Scanner scan = new Scanner(System.in);
    int Input;
    boolean IfGameOver;
    String []board = {"1","2","3","4","5","6","7","8","9"};
    IfGameOver = false;
    boolean Xturn = true;

    System.out.print("Welcome to Tic-Tac-Toe!\n\n");
do
    {

        {
         System.out.println(" " + board[0] + board[1] + board[2]);
         System.out.println(" " + board[3] + board[4] + board[5]);
         System.out.println(" " + board[6] + board[7] + board[8]);
        }
             if (Xturn)
             System.out.println("It is X's turn, position number?");
             else
             System.out.println("It is O's turn, position number?");

             Input = -1;
            do
                {
                try
                {
                Input = scan.nextInt();
                board[Input-1] = (Xturn?"X":"O");
                Xturn = !Xturn;
                }
                catch (Exception e)
                {
                    System.out.println("Invalid input. Please enter a valid position number");
                }
                }while(Input==-1);
    } while (!IfGameOver);
}
}