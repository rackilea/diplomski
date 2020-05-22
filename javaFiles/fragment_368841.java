import java.util.Random;

public class Main {
    private Random random = new Random();


    private void run() {
        for (int i=0; i<10; i++) {
            System.out.println(String.valueOf(i));
            System.out.println(random.nextInt() + " " + random.nextInt() + "\n");
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }
}