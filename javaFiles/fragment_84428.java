import java.util.Timer;
import java.util.TimerTask;

public class Tester {

    public static void main(String args[]) {

        String[] fname = { "file1.txt", "file2.txt", "file3.txt", "file4.txt", "file5.txt" };
        for (int i = 0; i < 5; i++) {
            try {

                MyRunnableThread mrt = new MyRunnableThread(fname[i]);
                Thread t = new Thread(mrt);
                t.start();

                final Timer timer = new Timer();
                timer.scheduleAtFixedRate(new TimerTask() {
                    int i = 6; // Time in seconds

                    public void run() {
                        System.out.println(i--);
                        if (i < 0) {
                            timer.cancel();
                            mrt.setRun(false);
                        }
                    }
                }, 0, 1000);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}