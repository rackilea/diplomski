public LocalDateTime localDateTimeFromWebKitTimestamp(long webKitTimestamp) {
    long epochStart = LocalDateTime
            .from(LocalDateTime.of(1601, Month.JANUARY, 1, 0, 0))
            .until(LocalDateTime.of(1970, Month.JANUARY, 1, 0, 0), ChronoUnit.MICROS);
    long delta = webKitTimestamp - epochStart;
    return LocalDateTime.ofInstant(
            Instant.ofEpochMilli(TimeUnit.MICROSECONDS.toMillis(delta)), ZoneId.systemDefault());
}