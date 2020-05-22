package t2;

    import java.util.Scanner;
    import java.util.Timer;
    import java.util.TimerTask;

    public class Stopwatch {
        static int interval;
        static Timer timer;

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int delay = 1000;
            int period = 1000;
            timer = new Timer();
            interval = 3;
            System.out.print("3,");
            timer.scheduleAtFixedRate(new TimerTask() {

                public void run() {
                    System.out.print(setInterval() + ",");

                }
            }, delay, period);
        }

        private static final Object setInterval() {
            String go = "go...go...go";
            if (interval == 1) {

                timer.cancel();
                return go;
            }

            return --interval;
        }
    }