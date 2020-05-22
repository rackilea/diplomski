import java.util.*;

public class Update {

   public final static int ITERATIONS = 5;

   public static void main(String[] args) {

      System.out.println("This program will simulate the game of Life.");

      Scanner console = new Scanner(System.in);

      System.out.println("Please input the size of your board.");

      System.out.println("Rows:");
      final int rows = console.nextInt();

      System.out.println("Columns:");
      final int columns = console.nextInt();

      System.out.println("Please enter a seed:");
      final long seed = console.nextLong();

      int[] birthLive = new int[4];
      boolean[][] board = new boolean[rows][columns];

      createMatrix(board, seed);

      birthAndLive(birthLive);

      for (int i = 0; i < ITERATIONS; i++) {
         printMatrix(board);
         updateMatrix(board, birthLive);
      }

   }

   public static void createMatrix(boolean[][] board, long seed) {

      Random seedBool = new Random(seed);

      for (int i = 0; i < board.length; i++) {
         for (int j = 0; j < board[i].length; j++) {
            board[i][j] = false;
         }
      }

      for (int i = 1; i < board.length - 1; i++) {
         for (int j = 1; j < board[i].length - 1; j++) {
            board[i][j] = seedBool.nextBoolean();
         }
      }

   }

   public static void birthAndLive(int[] birthLive) {

      Scanner console = new Scanner(System.in);

      System.out.println("Please input the birth range and the live range:");

      System.out.println("Birth (Low):");
      birthLive[0] = console.nextInt();

      System.out.println("Birth (High):");
      birthLive[1] = console.nextInt();

      System.out.println("Live (Low):");
      birthLive[2] = console.nextInt();

      System.out.println("Live (High):");
      birthLive[3] = console.nextInt();

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
      System.out.println();
   }

   public static void updateMatrix(boolean[][] board, int[] birthLive) {

      // clone the board so modified values don't affect the results of upcoming
      // spaces
      boolean[][] boardCopy = board.clone();
      for (int i = 0; i < board.length; i++)
         boardCopy[i] = board[i].clone();

      int count = 0;

      for (int i = 1; i < board.length - 1; i++) {
         for (int j = 1; j < board[i].length - 1; j++) {

            // different requirements for dead or living pieces' living status
            if (board[i][j] == false) {

               // check the nine-by-nine square, starting at (-1, 1) and ending
               // at (1, -1) where 0 is the affected location
               // * * *
               // * 0 *
               // * * *
               for (int ii = board[i - 1].length; ii < board[i + 1].length; ii++) {
                  for (int jj = board[j - 1].length; ii < board[j + 1].length; jj++) {
                     if (boardCopy[i][j] == true)
                        count++;
                  }
               }

               // check to see what high and low amt of required adjacent
               // lifeforms is
               if (count >= birthLive[0] && count <= birthLive[1])
                  board[i][j] = true;
               else
                  board[i][j] = false;
               count = 0;

            }

            else {

               for (int ii = board[i - 1].length; ii < board[i + 1].length; ii++) {
                  for (int jj = board[j - 1].length; ii < board[j + 1].length; jj++) {
                     if (boardCopy[i][j] == true)
                        count++;
                  }
               }

               count -= 1; // For board[i][j] is always true
               if (count >= birthLive[2] && count <= birthLive[3])
                  board[i][j] = true;
               else
                  board[i][j] = false;
               count = 0;

            }

         }
      }

   }
}