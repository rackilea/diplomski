public class Main
{

    private static String[][] board;
    private static ArrayList<String[][]> allBoards = new ArrayList<>();
    public static void main(String[] args) {

        board = new String[3][3];
        setBoard("A");
        allBoards.add(0,board);
        setBoard("B");
        allBoards.add(1,board);
        dumpAllBoards();
    }
    private static void dumpAllBoards() {
        int bCnt = 0;
        for (String[][] b : allBoards) {
            System.out.print(bCnt+": ");
            for (int i = 0; i < 9; i++) {
                System.out.print(b[i/3][i%3]+" ");
            }
            System.out.println();
            bCnt++;
        }
    }

    private static void setBoard(String v) {
        for (int i = 0; i < 9; i++) {
            board[i/3][i%3] = v;
        }
    }
}