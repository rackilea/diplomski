...
pool.shutdown();
if (pool.awaitTermination(<long>,<TimeUnit>)) {
    // finished before timeout
    doLotsOfThings(finsihedStuff);
} else {
    // Timeout occured.
}