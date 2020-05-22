public class Worker implements Runnable {
    private final int numberOfIterations;
    private final float[] x = new float[12000];

    public Worker(int numberOfIterations) {
        this.numberOfIterations = numberOfIterations;
    }

    public void run() {
        for(int i = 0; i < numberOfIterations; i++) {
            Random random = new Random();

            for (int i = 0; i < x.length; i++) {
                x[i] = random.nextFloat();
            }

            for (int i = 0; i < x.length; i++) {
                if (x[i] >= 0.75) {
                    \\ do something interesting
                }
            }
        }
    }
}


// *** Main Thread ***
Thread[] threads = new Thread[8];
for(int i = 0; i < 8; i++) {
    threads[i] = new Thread(new Worker(12000/8));
    threads[i].start();
}
for(int i = 0; i < 8; i++) {
    threads[i].join();
}