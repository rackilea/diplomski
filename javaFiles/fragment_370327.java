public class Main implements Runnable {
    private static volatile boolean finished = false;

    public static void main(String[] args) {
        new Thread(new Main()).start();
        new Main().run();
    }

    @Override
    public void run() {
        while (!finished) {
            // do stuff
            if (solutionFound) {
                finished = true;
                // save result
            }
        }
        return;
    }

}