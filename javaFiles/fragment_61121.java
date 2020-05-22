public class KeyPress implements Runnable {
public volatile String command;

public void run() {
    try {
        Robot r = new Robot();
        while (command.equals("up") && !Thread.currentThread().isInterrupted()) {
            r.keyPress(KeyEvent.VK_UP);
            r.delay(20);
        }
    } catch (Exception e) {
        System.out.println(e);
    }
}
}