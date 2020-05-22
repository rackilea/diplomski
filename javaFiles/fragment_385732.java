private long expectedTime; // calculated when bpm of timer is set

@Override
public void run() {
    long startTime = 0, elapsedTime = 0, threadSleepTime = 0;

    running = true;

    while (running) {
        startTime = System.nanoTime();

        tick();

        elapsedTime     = System.nanoTime() - startTime;

        threadSleepTime = expectedTime - elapsedTime;
        threadSleepTime = threadSleepTime < 0 ? 0 : threadSleepTime;

        try { TimeUnit.NANOSECONDS.sleep(threadSleepTime); } catch (Exception e) { }
    }
}