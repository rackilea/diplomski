public class Singleton {
    private static final Singleton INSTANCE = new Singleton();

    private int x; // global variable in disguise

    private Singleton() {
    }

    public static Singleton getInstance() {
        return INSTANCE;
    }

    public int getX() {
        return x;
    }

    public void setX(int newX) {
        x = newX;
    }
}