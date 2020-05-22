import java.util.concurrent.atomic.AtomicInteger;

public class MainLoop {

 private final AtomicInteger x = new AtomicInteger(0);

 public void startLoop() {
    Runnable runnable = () -> {
        while (x.get() < 100) {
            // Do stuff...
        }
    };

    // start the thread
    new Thread(runnable).start();
 }

 public void keyPressed(String key) {
    if (key.equals("Space")) {
        x.incrementAndGet();
    }
 }

}

public class KeyListener {

 public void keyPressed(KeyEvent e) {
    String key = KeyEvent.getKeyText(e.getKeyCode());
    for (GameObject go : gameobjects) {
        go.keyPressed(key);
    }
 }

}