public class CheckerGame {
    public int[][] board;
    public int getBoard(int row, int col){
        return board[row][col];
    }
    public void setBoard(int row, int col, int val){
        board[row][col] = val;
    }

    public CheckerGame(){ board = new int[8][8];

    public static void main(String... argv){
        CheckerGame game = new CheckerGame();
        game.setBoard(1,2,0);
    }

}