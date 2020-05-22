public class TimerTest {

    public static void main(String[] args) {
        Timer timer = new Timer("Happy", false);
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                System.out.println("Hello, I'm from the future!");
            }
        }, 5000);

        System.out.println("Hello, I'm from the present");
    }
}