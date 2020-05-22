acquireLockAndRunOnNewThread(() -> {
    latch.countDown();
    continueWithOtherStuff();
}

//do not continue until the latch has counted down to zero.
latch.await();
continueWithOtherStuffThatAlsoAcquiresALockAtSomePointInTime()