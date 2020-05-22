public class Main
{

    private static String[][] board;
    private static ArrayList<String[][]> allBoards = new ArrayList<>();
    public static void main(String[] args) {

        board = new String[3][3];
        setBoard("A");
        cloneBoard(0);
        setBoard("B");
        cloneBoard(1);
        dumpAllBoards();


    }

    // omitted dumpAllBoards - see previous

    private static void cloneBoard(int slot) {
            allBoards.add(slot,deepCopyStrMatrix(board));
    }

    // copied from: https://stackoverflow.com/a/9106176/2711811
    public static String[][] deepCopyStrMatrix(String[][] input) {
        if (input == null)
            return null;
        String[][] result = new String[input.length][];
        for (int r = 0; r < input.length; r++) {
            result[r] = input[r].clone();
        }
        return result;
    }
}