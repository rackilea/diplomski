public class GameControl {

    private int x,y;

    public GameControl(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private static void reset(GameControl gc) {
        gc = new GameControl(0,0);
    }

    private static void resetTheOtherWay(GameControl gc) {
        gc.x = 0;
        gc.y = 0;
    }

    @Override
    public String toString() {
        return "GameControl [x=" + x + ", y=" + y + "]";
    }

    public static void main(String[] args) {
        GameControl gc1 = new GameControl(10,20);
        System.out.println(gc1);
        reset(gc1);
        System.out.println(gc1);
        resetTheOtherWay(gc1);
        System.out.println(gc1);
    }
}