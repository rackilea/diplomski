public class Grid {
    private int[][] numberOfObjects = new int[10][10];

    public void put(int x, int y) {
        numberOfObjects[y][x]++;
    }

    public void pick(int x, int y) {
        numberOfObjects[y][x]--;
    }
}