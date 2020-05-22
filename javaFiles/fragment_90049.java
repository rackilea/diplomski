public class Coordinates {
    private int x;
    private int y;
    public synchronized int[] getXY() {return new int[]{x, y};}
    public synchronized void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }
}