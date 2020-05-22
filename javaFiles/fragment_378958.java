private KafkaServer server = new KafkaServer(config, new SystemTime());

private static class SystemTime implements Time {

    @Override
    public long milliseconds() {
        return System.currentTimeMillis();
    }

    @Override
    public long nanoseconds() {
        return System.nanoTime();
    }

    @Override
    public void sleep(long arg0) {
        try {
            Thread.sleep(arg0);
        } catch (InterruptedException e) {
            log.error("Kafka systemtime interrupted",e);
        }
    }

}