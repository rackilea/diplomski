pool.shutdown();
final boolean terminated = pool.awaitTermination(8, TimeUnit.SECONDS);
if (!terminated) {
    throw new IllegalStateException("pool shutdown timeout");
}

resultFile.close();