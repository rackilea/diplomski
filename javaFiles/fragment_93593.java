public class Main {

    private static final IntFunction<Integer> INC = val -> val + 1;

    private int x = 42;

    public static void main(String[] args) {
        Main main = new Main();
        main.x = INC.apply(main.x);
    }

}