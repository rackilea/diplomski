public class Koord {

    private int number;
    private static int numberOfNodes = 0;
    private int x;
    private int y;

    public Koord(int x, int y) {
        this.x = x;
        this.y = y;
        this.number = ++numberOfNodes;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getNumber() {
        return number;
    }
}