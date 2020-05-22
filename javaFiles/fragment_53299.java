public class UniqueNano {
    private static volatile long a = -1, b = -2;

    public static void main(String[] args) {
        long max = 1_000_000;
        new Thread(() -> {
            for (int i = 0; i < max; i++) { a = System.nanoTime(); }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < max; i++) { b = System.nanoTime(); }
        }).start();
        for (int i = 0; i < max; i++) {
            if (a == b) {
                System.out.println("nanoTime not unique");
            }
        }
    }
}