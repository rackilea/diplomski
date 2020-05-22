public class HelloWorld {

     public static void main(String []args){
             String[][] board = new String[8][8];

         for (int i = 0; i < 8; i++) {
             for (int j = 0; j < 8; j++) {
                 board[i][j] = (i + j) % 2 == 0 ? "X" : "O";
             }
         }

         for (int i = 0; i < 8; i++) {
             for (int j = 0; j < 8; j++) {
                 System.out.print(board[i][j]+" ");
             }
             System.out.println();
         }
     }
}