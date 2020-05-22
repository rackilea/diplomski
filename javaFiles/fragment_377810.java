public static void main(String[] args) throws IOException {
    // in this sample these dirs are supposed to exist
    final String workingDirectory = "./data/tmp";
    final String outputDirectory = "./data/csv";

    final String outputFilename = "r.out";
    final int addIntervalSeconds = 1;
    final int drainIntervalSeconds = 5;

    final FileBasedTextBatch batch = new FileBasedTextBatch(Paths.get(workingDirectory));
    final ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

    final ScheduledFuture<?> producer = executor.scheduleAtFixedRate(
        () -> batch.add(
            // adding formatted date/time to imitate another CSV line
            LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
        ),
        0, addIntervalSeconds, TimeUnit.SECONDS);

    final ScheduledFuture<?> consumer = executor.scheduleAtFixedRate(
        () -> batch.drainTo(Paths.get(outputDirectory, outputFilename)),
        0, drainIntervalSeconds, TimeUnit.SECONDS);

    try {
        // awaiting some limited time for demonstration 
        producer.get(30, TimeUnit.SECONDS);
    }
    catch (InterruptedException e) {
        Thread.currentThread().interrupt();
    }
    catch (ExecutionException e) {
        System.err.println("Producer failed: " + e);
    }
    catch (TimeoutException e) {
        System.out.println("Finishing producer/consumer...");
        producer.cancel(true);
        consumer.cancel(true);
    }
    executor.shutdown();
}

static class FileBasedTextBatch {
    private final Object lock = new Object();
    private final Path workingDir;
    private Output output;

    public FileBasedTextBatch(Path workingDir) throws IOException {
        this.workingDir = workingDir;
        output = new Output(this.workingDir);
    }

    /**
     * Adds another line of text to the batch.
     */
    public void add(String textLine) {
        synchronized (lock) {
            output.writer.println(textLine);
        }
    }

    /**
     * Moves currently collected batch to the file at the specified path.
     * The file will be overwritten if exists.
     */
    public void drainTo(Path targetPath) {
        try {
            final long startNanos = System.nanoTime();
            final Output output = getAndSwapOutput();
            final long elapsedMillis =
                TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos);
            System.out.printf("Replaced the output in %d millis%n", elapsedMillis);
            output.close();
            Files.move(
                output.file,
                targetPath,
                StandardCopyOption.ATOMIC_MOVE,
                StandardCopyOption.REPLACE_EXISTING
            );
        }
        catch (IOException e) {
            System.err.println("Failed to drain: " + e);
            throw new IllegalStateException(e);
        }
    }

    /**
     * Replaces the current output with the new one, returning the old one.
     * The method is supposed to execute very quickly to avoid delaying the producer thread.
     */
    private Output getAndSwapOutput() throws IOException {
        synchronized (lock) {
            final Output prev = this.output;
            this.output = new Output(this.workingDir);
            return prev;
        }
    }
}

static class Output {
    final Path file;
    final PrintWriter writer;

    Output(Path workingDir) throws IOException {
        // performs very well on local filesystems when working directory is empty;
        // if too slow, maybe replaced with UUID based name generation
        this.file = Files.createTempFile(workingDir, "csv", ".tmp");
        this.writer = new PrintWriter(Files.newBufferedWriter(this.file));
    }

    void close() {
        if (this.writer != null)
            this.writer.flush();
            this.writer.close();
    }
}