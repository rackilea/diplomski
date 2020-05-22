boolean processScheduled = false;

// ...

if (fixedRate >= 0) {
    Assert.isTrue(!processedSchedule, errorMessage);
    processedSchedule = true;
    this.registrar.addFixedRateTask(new IntervalTask(runnable, fixedRate, initialDelay));
}

// ...

Assert.isTrue(processedSchedule, errorMessage);