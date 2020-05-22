public class RandomGenerator {
    private final ExecutorService generator = Executors.newSingleThreadExecutor(new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r, "generator");
            t.setDaemon(true);
            return t;
        }
    });
    private final Exchanger<double[][]> exchanger = new Exchanger<>();
    private double[][] buffer;
    private int nextRow = Integer.MAX_VALUE;

    public RandomGenerator(final int rows, final int columns) {
        buffer = new double[rows][columns];
        generator.submit(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                Random random = new Random();
                double[][] buffer2 = new double[rows][columns];
                while (!Thread.interrupted()) {
                    for (int r = 0; r < rows; r++)
                        for (int c = 0; c < columns; c++)
                            buffer2[r][c] = random.nextGaussian();
                    buffer2 = exchanger.exchange(buffer2);
                }
                return null;
            }
        });
    }

    public double[] nextArray() throws InterruptedException {
        if (nextRow >= buffer.length) {
            buffer = exchanger.exchange(buffer);
            nextRow = 0;
        }
        return buffer[nextRow++];
    }
}