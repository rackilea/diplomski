import java.util.concurrent.CountDownLatch;
public class AskUser implements Runnable {

    final CountDownLatch userInput = new CountDownLatch(1);
    IUpdater updater;
    String command;
    volatile int result;

    @Override
    public void run() {

        try {
            result = updater.askPermission(command);
        } finally {
            userInput.countDown();
        }
    }
}