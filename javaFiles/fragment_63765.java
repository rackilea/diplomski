// When you're stopping the stopwatch, use this
// This is the number of milliseconds the timer was running for
elapsedTimeBeforePause = SystemClock.elapsedRealtime() - timer.getBase();

// When you're starting it again:
timer.setBase(SystemClock.elapsedRealtime() - elapsedTimeBeforePause);