public class board {

    private static final int ROWS=3;
    private static final int COLS=3;
    private int[][] board1 = new int[ROWS][COLS];


    //constructor
    public  board() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board1[i][j]=0;
                printBoard();           

            }
        }
    }


    public void printBoard(){
       for(int row =0; row<ROWS; row++){
           for (int col=0; col<COLS; col++){
               printCell(board1[row][col]);
               if (col != (COLS-1)) {
                   System.out.print("|");   // print vertical partition
               }
            }
           System.out.println("");
           if (row !=(ROWS-1)) {
               System.out.println("-----------");
           }
        }
    System.out.println();
    }


    public void printCell(int content) {
         if (content == 0)  {System.out.print("   ");}
    }
}