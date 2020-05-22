public class Main {
    public static void main(String[] args) {
        Frame f = new Frame();
        f.main();

        for (int i = 0; f.isRunning(); i++) {
            // ...
        }
    }
}