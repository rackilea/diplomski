public class Main {

    private int x = 42;

    public static void main(String[] args) {
        Main main = new Main();
        incrementX(main);
    }

    private static void incrementX(Main main) {
        main.x++;
    }
}