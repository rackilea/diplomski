public class IslandConnectedCell {

    public static void main(String... args) {
        int[][] board = { {1,0,0,0,1},
                          {1,1,1,1,1},
                          {0,0,0,0,0},
                          {1,1,0,1,1} };
        System.out.println(new IslandConnectedCell(board).getIslandSizes());
    }

    private final int[][] board;
    private final int rows;
    private final int cols;

    public IslandConnectedCell(int[][] board) {
        this.board = board;
        this.rows = board.length;
        this.cols = board[0].length;
    }

    public List<Integer> getIslandSizes() {
        boolean visited[][] = new boolean[this.rows][this.cols];
        List<Integer> countList = new ArrayList<>();
        for (int row = 0; row < this.rows; row++)
            for (int col = 0; col < this.cols; col++)
                if (this.board[row][col] == 1 && ! visited[row][col])
                    countList.add(mark(row, col, visited));
        return countList;
    }

    private int mark(int row, int col, boolean[][] visited) {
        if (row >= this.rows || row < 0 || col >= this.cols || col < 0 || this.board[row][col] == 0 || visited[row][col])
            return 0;
        visited[row][col] = true;
        int count = 1;
        for (int r = -1; r <= 1; r++)
            for (int c = -1; c <= 1; c++)
                if (r != 0 || c != 0)
                    count += mark(row + r, col + c, visited);
        return count;
    }

}