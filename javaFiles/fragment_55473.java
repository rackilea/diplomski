public class Main {
    public static volatile int x = 0;
    public static volatile boolean running = true;

    public static void main(String... args) {
        Thread observer = new Thread(() -> {
            while (true) {
                int x = Main.x;
                System.out.println("Observer observed: " + x);
                if (0 != x) {
                    break;
                }
            }
            Main.running = false;
        });
        observer.start();

        while (running) {
            Main.x = Main.x++;
        }
        System.out.println(Main.x);
    }
}