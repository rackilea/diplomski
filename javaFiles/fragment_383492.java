public void run() throws InterruptedException {

    int frames = 0;
    Duration threashold = Duration.ofMillis(1000 / 59);
    Duration cycle = Duration.ofSeconds(1);

    Instant cycleStart = Instant.now();

    // main game loop.
    while (isRunning) {
        Instant start = Instant.now();
        // Some update function...

        Thread.sleep(rnd.nextInt(32));

        Duration processTime = Duration.between(start, Instant.now());
        Duration remainingTime = threashold.minusMillis(processTime.toMillis());
        long delay = remainingTime.toMillis();
        if (delay > 0) {
            Thread.sleep(delay);
        } else {
            System.out.println("Dropped frame");
        }

        frames++;
        // Render the output

        Duration cycleTime = Duration.between(cycleStart, Instant.now());
        if (cycleTime.compareTo(cycle) >= 0) {
            cycleStart = Instant.now();
            System.out.println(frames);
            frames = 0;
        }
    }

}