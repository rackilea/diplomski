import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestGameLoop {

    public static void main(String[] args) {
        new TestGameLoop();
    }

    public TestGameLoop() {
        gameLoop();
    }

    public static class Constants {

        public static final double OPTIMAL = 25; // fps...

    }

    private boolean game = true;
    private long lastLoop;
    private long lastFps;
    private long fps;

    private void gameLoop() {
        new Thread() {

            private long last;
            private long start;
            private int wait;

            public void run() {

                // Calculate the optimal/maximum delay time
                // This is converted to nanos so it can be 
                // used to calculate the actual delay...
                long millisPerSecond = TimeUnit.MILLISECONDS.convert(1, TimeUnit.SECONDS);
                long optimalDelay =  Math.round(millisPerSecond / Constants.OPTIMAL);

                optimalDelay = TimeUnit.MILLISECONDS.toNanos(optimalDelay);

                // Last start of a "second" loop                    
                long loop = System.nanoTime();
                // While gaming...
                while (game) {
                    // Start of this cycle...
                    long now = System.nanoTime();

                    // Update the state and render the 
                    // current frame...
                    update();
                    render();

                    // How long did that update take??
                    long timeTaken = System.nanoTime();
                    long delta = timeTaken - now;

                    // Subtract the delay from the maximum delay
                    long delay = optimalDelay - delta;
                    if (delay > 0) {
                        try {
                            // Sleep expects milliseconds...
                            delay = TimeUnit.NANOSECONDS.toMillis(delay);
                            Thread.sleep(delay);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }

                    // Calculate if we've being running for a second yet...
                    long loopDelay = TimeUnit.NANOSECONDS.toSeconds(System.nanoTime() - loop);
                    // If the loop has been cycling for a second...
                    if (loopDelay >= 1) {
                        // Reset the loop time
                        loop = System.nanoTime();
                        System.out.println("FPS = " + fps);
                        fps = 0;
                    } else {
                        // Add another frame to the pile...
                        fps++;
                    }
                }
            }
        }.start();
    }

    public void update() {
        try {
            Thread.sleep(Math.round(Math.random() * 20));
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public void render() {
        try {
            Thread.sleep(Math.round(Math.random() * 20));
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

}