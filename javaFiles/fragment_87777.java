public static long toMinuteResolution(long timestamp) {
    assert timestamp >= 0 : "This optimized method doesn’t work for negative timestamps.";
    assert Duration.ofSeconds(Instant.ofEpochMilli(timestamp).atZone(ZoneId.systemDefault()).getOffset().getTotalSeconds())
                    .toSecondsPart() == 0
            : "This optimized method doesn’t work for an offset of "
                    + Instant.ofEpochMilli(timestamp).atZone(ZoneId.systemDefault()).getOffset();
    return TimeUnit.MINUTES.toMillis(TimeUnit.MILLISECONDS.toMinutes(timestamp));
}