public static long toMinuteResolution(long timestamp) {
    return Instant.ofEpochMilli(timestamp)
            .atZone(ZoneId.systemDefault())
            .truncatedTo(ChronoUnit.MINUTES)
            .toInstant()
            .toEpochMilli();
}