import java.util.Queue;
import java.util.LinkedList;

class Pair<L,R> {
    private L l;
    private R r;

    public Pair(L l, R r){
        this.l = l;
        this.r = r;
    }

    public L getL(){ return l; }
    public R getR(){ return r; }
}


public class HelloW {
    static int d = 20;
    static boolean[][] visited = new boolean[d][d];
    static int[][] board = new int[d][d];

    static Queue<Pair<Integer, Integer>> Q = new LinkedList<Pair<Integer, Integer>>();

    static void colorize(int color, int orig_x, int orig_y) {
        Q.add(new Pair<Integer, Integer>(orig_x, orig_y));

        while (Q.isEmpty() == false) {
            Pair<Integer,Integer> foo = Q.remove();
            int x = foo.getL();
            int y = foo.getR();
            int old_color = board[x][y];

            visited[x][y] = true;
            board[x][y]  = color;

            if (x + 1 < d)
                if (board[x + 1][y] == old_color && visited[x + 1][y] == false)
                    Q.add(new Pair<Integer, Integer>(x+1, y));
            if (x - 1 >= 0)
                if (board[x - 1][y] == old_color && visited[x - 1][y] == false)
                    Q.add(new Pair<Integer, Integer>(x-1, y));
            if (y + 1 < d)
                if (board[x][y + 1] == old_color && visited[x][y + 1] == false)
                    Q.add(new Pair<Integer, Integer>(x, y+1));
            if (y - 1 >= 0)
                if (board[x][y - 1] == old_color && visited[x][y - 1] == false)
                    Q.add(new Pair<Integer, Integer>(x, y-1));
        }
    }

    public static void main (String[] args) {
        colorize(1, 0, 0);
    }
}