executor.shutdown();
try {
    executor.awaitTermination(4 * 3600, TimeUnit.SECONDS);
} catch (Exception e) {
    e.printStackTrace();
}