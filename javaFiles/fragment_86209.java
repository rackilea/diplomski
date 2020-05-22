public class StopWatch {

    private Instant startTime;
    private Duration totalRunTime = Duration.ZERO;

    public StopWatch start() {
        startTime = Instant.now();
        return this;
    }

    public StopWatch stop() {
        Duration runTime = Duration.between(startTime, Instant.now());
        totalRunTime = totalRunTime.plus(runTime);
        startTime = null;
        return this;
    }

    public StopWatch pause() {
        return stop();
    }

    public StopWatch resume() {
        return start();
    }

    public StopWatch reset() {
        stop();
        totalRunTime = Duration.ZERO;
        return this;
    }

    public boolean isRunning() {
        return startTime != null;
    }

    public Duration getDuration() {
        Duration currentDuration = Duration.ZERO;
        currentDuration = currentDuration.plus(totalRunTime);
        if (isRunning()) {
            Duration runTime = Duration.between(startTime, LocalDateTime.now());
            currentDuration = currentDuration.plus(runTime);
        }
        return currentDuration;
    }
}